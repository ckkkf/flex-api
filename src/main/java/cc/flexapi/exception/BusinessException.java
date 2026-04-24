package cc.flexapi.exception;

import cc.flexapi.constants.CommonError;

/**
 * @author ckkk
 * @version 1.0
 * 业务异常
 * @since 2026-04-20 18:51
 */
public class BusinessException extends RuntimeException {

    private String message;

    public BusinessException(String message) {
        super(message);
    }

    private static void cast(String message) {
        throw new BusinessException(message);
    }

    private static void cast(CommonError error) {
        throw new BusinessException(error.getErrorMessage());
    }
}
