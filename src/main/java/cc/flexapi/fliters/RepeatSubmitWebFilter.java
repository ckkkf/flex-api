package cc.flexapi.fliters;

import cc.flexapi.constants.RedisConstants;
import cc.flexapi.exception.BusinessException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Set;

/**
 * 全局防重复提交过滤器。
 *
 * <p>设计目标：</p>
 * <ul>
 *     <li>统一拦截整个项目的写请求，避免相同请求在短时间内被重复执行。</li>
 *     <li>兼容旧接口：只有客户端显式携带幂等键时才启用防重逻辑。</li>
 *     <li>基于 Redis 的短期分布式锁实现，适合 WebFlux / Reactor 场景。</li>
 * </ul>
 *
 * <p>默认行为：</p>
 * <ul>
 *     <li>仅拦截 {@code POST}/{@code PUT}/{@code PATCH}/{@code DELETE}。</li>
 *     <li>优先读取请求头 {@code X-Idempotency-Key}。</li>
 *     <li>兼容读取查询参数 {@code requestId}/{@code idempotencyKey}。</li>
 *     <li>若未携带幂等键，则直接放行，不影响现有接口调用。</li>
 * </ul>
 *
 * <p>Redis Key 由“客户端标识 + 请求方法 + 请求路径 + 幂等键”组成，
 * 在指定 TTL 时间内再次提交同一请求时将被直接拦截。</p>
 *
 * @author ckkk
 * @since 2026-04-25
 */
@Slf4j
@Component
public class RepeatSubmitWebFilter implements WebFilter {

    /**
     * 推荐前端统一传递的幂等请求头。
     */
    private static final String IDEMPOTENCY_HEADER = "X-Idempotency-Key";

    /**
     * 需要执行防重复提交校验的 HTTP 方法。
     * 只保护有副作用的写操作，请求查询类接口不参与拦截。
     */
    private static final Set<HttpMethod> GUARDED_METHODS = Set.of(
            HttpMethod.POST,
            HttpMethod.PUT,
            HttpMethod.PATCH,
            HttpMethod.DELETE
    );

    /**
     * 默认排除的路径前缀。
     * 这些接口一般是文档、监控或基础设施路径，不需要重复提交保护。
     */
    private static final Set<String> EXCLUDED_PATH_PREFIXES = Set.of(
            "/v3/api-docs",
            "/swagger-ui",
            "/actuator"
    );

    /**
     * Redis 分布式锁的有效时间。
     * <p>
     * 在该时间窗口内，同一个客户端对同一资源使用同一个幂等键重复提交时，
     * 将被判定为重复请求。
     */
    private static final Duration LOCK_TTL = Duration.ofSeconds(5);

    /**
     * 重复提交时返回给客户端的提示文案。
     */
    private static final String DUPLICATE_MESSAGE = "请求重复，请勿重复提交";

    /**
     * 用于写入 Redis 防重锁的响应式模板。
     */
    @Resource
    private ReactiveStringRedisTemplate reactiveStringRedisTemplate;

    /**
     * WebFlux 全局过滤入口。
     * <p>
     * 处理流程：
     * <ol>
     *     <li>判断当前请求是否属于需要防重的写操作。</li>
     *     <li>排除 swagger/actuator 等基础路径。</li>
     *     <li>解析幂等键；如果没有幂等键，则直接放行。</li>
     *     <li>基于 Redis 的 setIfAbsent 尝试抢占短期锁。</li>
     *     <li>抢锁成功则继续执行请求，失败则直接返回 409。</li>
     * </ol>
     *
     * @param exchange 当前请求上下文
     * @param chain    过滤器链
     * @return 响应式执行结果
     */
    @NonNull
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, @NonNull WebFilterChain chain) {
        // 解析请求
        ServerHttpRequest request = exchange.getRequest();
        HttpMethod method = request.getMethod();
        String path = request.getPath().value();

        // 放行非写请求
        if (!GUARDED_METHODS.contains(method)) {
            return chain.filter(exchange);
        }
        // 放行文档、监控等路径
        if (isExcludedPath(path)) {
            return chain.filter(exchange);
        }
        // 放行没带幂等键的请求
        String idempotencyKey = resolveIdempotencyKey(request);
        if (StrUtil.isBlank(idempotencyKey)) {
            return chain.filter(exchange);
        }

        // 用 “客户端 + 方法 + 路径 + 幂等键” 构造唯一锁
        String client = resolveClientIdentity(request);
        String redisKey = buildRedisKey(client, method.name(), path, idempotencyKey);

        return reactiveStringRedisTemplate.opsForValue()
                // SET NX，只有第一次请求能抢到锁。
                .setIfAbsent(redisKey, String.valueOf(System.currentTimeMillis()), LOCK_TTL)
                .flatMap(locked -> {
                    // 抢锁失败，说明同一请求在锁有效期内重复提交，直接拦截。
                    if (!locked) {
                        log.warn("[防重复提交] 拦截重复请求 method={}, path={}, key={}, client={}",
                                method.name(), path, idempotencyKey, client);
                        return Mono.error(new BusinessException("请求重复，请勿重复提交"));
//                        return writeDuplicateResponse(exchange.getResponse());
                    }
                    // 抢锁成功，说明当前请求是本时间窗口内第一次提交。
                    return chain.filter(exchange);
                });
    }

    /**
     * 判断当前请求路径是否属于排除范围。
     *
     * @param path 请求路径
     * @return true 表示跳过防重校验
     */
    private boolean isExcludedPath(String path) {
        return EXCLUDED_PATH_PREFIXES.stream().anyMatch(path::startsWith);
    }

    /**
     * 解析请求携带的幂等键。
     *
     * @param request 当前请求对象
     * @return 幂等键；若为空则返回 null
     */
    private String resolveIdempotencyKey(ServerHttpRequest request) {
        // 优先使用标准请求头
//        String key = StrUtil.firstNonBlank(
//                request.getHeaders().getFirst(IDEMPOTENCY_HEADER),
//                request.getQueryParams().getFirst("requestId"),
//                request.getQueryParams().getFirst("idempotencyKey")
//        );

        String key = request.getHeaders().getFirst(IDEMPOTENCY_HEADER);
        return StrUtil.isBlank(key) ? null : StrUtil.trim(key);
    }

    /**
     * 构造 Redis 防重 Key。
     *
     * @param client         客户端身份标识
     * @param method         HTTP 方法
     * @param path           请求路径
     * @param idempotencyKey 幂等键
     * @return Redis Key
     */
    private String buildRedisKey(String client, String method, String path, String idempotencyKey) {
        return RedisConstants.FORMAT_REPEAT_SUBMIT.formatted(
                client, method, StrUtil.format("{}:{}", path, idempotencyKey)
        );
    }

    /**
     * 解析客户端身份标识。
     *
     * @param request 当前请求对象
     * @return 客户端标识字符串
     */
    private String resolveClientIdentity(ServerHttpRequest request) {
        // 优先用 Authorization 头
        String authorization = request.getHeaders().getFirst("Authorization");
        if (StrUtil.isNotBlank(authorization)) {
            return buildHashedIdentity("auth", authorization);
        }

        // 退化为 Cookie 区分会话。
        String cookieToken = request.getCookies().values().stream()
                .flatMap(java.util.Collection::stream)
                .map(cookie -> StrUtil.format("{}={}", cookie.getName(), cookie.getValue()))
                .findFirst()
                .orElse(null);
        if (StrUtil.isNotBlank(cookieToken)) {
            return buildHashedIdentity("cookie", cookieToken);
        }

        // 退化为代理转发 IP。
        String forwardedFor = request.getHeaders().getFirst("X-Forwarded-For");
        if (StrUtil.isNotBlank(forwardedFor)) {
            return StrUtil.format("ip:{}", StrUtil.trim(StrUtil.subBefore(forwardedFor, ',', false)));
        }

        // 退化为使用直连 IP
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        if (remoteAddress != null && remoteAddress.getAddress() != null) {
            return StrUtil.format("ip:{}", remoteAddress.getAddress().getHostAddress());
        }
        return "anonymous";
    }

    /**
     * 生成脱敏后的客户端标识，避免日志和 Redis Key 中直接暴露凭证原文。
     *
     * @param prefix 标识前缀
     * @param raw    原始值
     * @return 脱敏后的标识
     */
    private String buildHashedIdentity(String prefix, String raw) {
        return StrUtil.format("{}:{}", prefix, SecureUtil.md5(raw));
    }
}
