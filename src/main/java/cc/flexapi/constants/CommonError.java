package cc.flexapi.constants;

/**
 * @author ckkk
 * @version 1.0
 *
 * @since 2026-04-20 18:58
 */
public enum CommonError {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR("执行过程异常，请重试。"),
    /**
     * 参数错误
     */
    PARAMS_ERROR("非法参数"),
    /**
     * 对象为空
     */
    OBJECT_NULL("对象为空"),
    /**
     * 查询结果为空
     */
    QUERY_NULL("查询结果为空"),
    /**
     * 请求参数为空
     */
    REQUEST_NULL("请求参数为空");

    private final String message;

    private CommonError(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
