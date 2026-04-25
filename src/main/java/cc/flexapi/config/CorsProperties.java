package cc.flexapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局跨域配置。
 *
 * <p>默认放行本地开发环境常见前端地址，生产环境请在配置文件中按需收敛。</p>
 *
 * @author ckkk
 * @since 2026-04-25
 */
@Data
@ConfigurationProperties(prefix = "flexapi.cors")
public class CorsProperties {

    /**
     * 是否启用全局跨域配置。
     */
    private boolean enabled = true;

    /**
     * 允许的 Origin Pattern。
     */
    private List<String> allowedOriginPatterns = new ArrayList<>(List.of(
            "http://localhost:*",
            "http://127.0.0.1:*",
            "https://localhost:*",
            "https://127.0.0.1:*"
    ));

    /**
     * 允许的请求方法。
     */
    private List<String> allowedMethods = new ArrayList<>(List.of(
            "GET",
            "POST",
            "PUT",
            "PATCH",
            "DELETE",
            "OPTIONS"
    ));

    /**
     * 允许的请求头。
     */
    private List<String> allowedHeaders = new ArrayList<>(List.of("*"));

    /**
     * 暴露给前端读取的响应头。
     */
    private List<String> exposedHeaders = new ArrayList<>(List.of(
            "Authorization",
            "Content-Disposition",
            "X-Idempotency-Key"
    ));

    /**
     * 是否允许携带 Cookie / 凭证。
     */
    private boolean allowCredentials = true;

    /**
     * 预检请求缓存时间，单位秒。
     */
    private Long maxAge = 3600L;
}
