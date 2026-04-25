package cc.flexapi.exception;

import cc.flexapi.model.response.R;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author ckkk
 * @since 2026-04-25
 */
@Slf4j
@Component
@Order(-2)
public class GlobalWebExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(ex);
        }

        if (!(ex instanceof BusinessException businessException)) {
            return Mono.error(ex);
        }

        log.error("[WebFlux异常处理器] 捕获 BusinessException 异常：{}", businessException.getMessage(), businessException);
        return R.error(businessException.getMessage())
                .flatMap(body -> writeJson(exchange, HttpStatus.OK, body));
    }

    private Mono<Void> writeJson(ServerWebExchange exchange, HttpStatus status, Object body) {
        byte[] bytes = JSONUtil.toJsonPrettyStr(body).getBytes(StandardCharsets.UTF_8);
        var response = exchange.getResponse();
        response.setStatusCode(status);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(Mono.just(response.bufferFactory().wrap(bytes)));
    }
}
