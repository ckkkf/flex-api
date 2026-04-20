package cc.flexapi.model.response;


import lombok.Data;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

/**
 *
 *
 * @author ckkk
 * @version 1.0
 * @since 2025-05-24 17:49
 */
@Data
public class R<T> {

    private Integer code;

    private String message;

    private Long timestamp;

    private Boolean success;

    private T data;

    private R(int code, String message, T data) {
        this.code = code;
        this.success = code == 200;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.data = data;
    }

    /**
     * 响应式 响应成功
     *
     * @param momo 响应数据
     * @param <T>  响应数据类型
     * @return 响应式R
     */
    public static <T> Mono<R<T>> ok(Mono<T> momo) {
        return momo.map(R::okSync);
    }

    /**
     * 响应式 响应失败
     *
     * @param message 错误信息
     * @param <T>     响应数据类型
     * @return 响应式R
     */
    public static <T> Mono<R<T>> error(String message) {
        return Mono.just(errorSync(message));
    }

    /**
     * 响应式 响应失败
     *
     * @param code    错误码
     * @param message 错误信息
     * @param <T>     响应数据类型
     * @return 响应式R
     */
    public static <T> Mono<R<T>> error(Integer code, String message) {
        return Mono.just(errorSync(code, message));
    }

    /**
     * 响应式 响应失败
     *
     * @param status  错误码
     * @param message 错误信息
     * @param <T>     响应数据类型
     * @return 响应式R
     */
    private static <T> Mono<R<T>> error(HttpStatus status, String message) {
        return Mono.just(errorSync(status, message));
    }

    private static <T> R<T> errorSync(String message) {
        return new R<>(500, message, null);
    }

    private static <T> R<T> errorSync(HttpStatus status, String message) {
        return new R<>(status.value(), message, null);
    }

    private static <T> R<T> errorSync(Integer code, String message) {
        return new R<>(code, message, null);
    }

    private static <T> R<T> okSync() {
        return new R<>(200, "操作成功", null);
    }

    private static <T> R<T> okSync(T data) {
        return new R<>(200, "操作成功", data);
    }

}
