package cc.flexapi.exception;

import cc.flexapi.model.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-20 18:37
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Mono<R<T>> handleBusinessException(Exception e) {
        log.error("[全局异常处理器] 捕获BusinessException异常：{}", e.getMessage(), e);
        return R.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Mono<R<T>> handleException(Exception e) {
        log.error("[全局异常处理器] 捕获Exception异常：{}", e.getMessage(), e);
        return R.error("系统异常");
    }

}
