package cc.flexapi.exception;

import cc.flexapi.model.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;
import java.util.stream.Collectors;

/**
 * @author ckkk
 * @version 1.0
 *
 * @since 2026-04-20 18:37
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Mono<R<T>> handleBusinessException(BusinessException e) {
        log.error("[全局异常处理器] 捕获 BusinessException 异常：{}", e.getMessage(), e);
//        return R.error(e.getMessage());
        return Mono.error(e);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public <T> Mono<R<T>> handleWebExchangeBindException(WebExchangeBindException e, ServerWebExchange exchange) {
        // 获取request
        ServerHttpRequest request = exchange.getRequest();
        // 解析path
        String path = request.getURI().getPath();
        // 解析method
        String method = request.getMethod().name();
        // 解析参数
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        // 解析ip
        String hostAddress = "未知";
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        if (remoteAddress != null) {
            hostAddress = remoteAddress.getAddress().getHostAddress();
        }
        // 解析错误信息
        String errorMessage = e.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("，"));
        log.debug("[全局异常处理器] 来自 ip:{} 的请求 {} {} 校验失败: {}", hostAddress, method, path, errorMessage);
        return R.error(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Mono<R<T>> handleException(Exception e) {
        log.error("[全局异常处理器] 捕获 Exception 异常：{}", e.getMessage(), e);
        return R.error("系统异常");
    }

}
