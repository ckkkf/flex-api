package cc.flexapi.exception;

import cc.flexapi.constants.CommonError;
import cc.flexapi.model.response.R;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @description 业务异常
 * @since 2026-04-20 18:51
 */
public class BusinessException extends RuntimeException {

    private String message;


    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public static <T> Mono<R<T>> cast(String message) {
        throw new BusinessException(message);
    }

    public static void cast(CommonError error){
        throw new BusinessException(error.getErrorMessage());
    }
}
