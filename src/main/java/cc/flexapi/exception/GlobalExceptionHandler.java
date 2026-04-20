package cc.flexapi.exception;

import cc.flexapi.model.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

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
        log.error("[全局异常处理器] 捕获 BusinessException 异常：{}", e.getMessage(), e);
        return R.error(e.getMessage());
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public <T> Mono<R<T>> handleWebExchangeBindException(Exception e) {
        List<ObjectError> allErrors = ((WebExchangeBindException) e).getAllErrors();
        String errorMessage = allErrors.stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("，"));
        log.debug("[全局异常处理器] 捕获 WebExchangeBindException 异常：{}", errorMessage, e);
        return R.error(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> Mono<R<T>> handleException(Exception e) {
        log.error("[全局异常处理器] 捕获 Exception 异常：{}", e.getMessage(), e);
        return R.error("系统异常");
    }

}
