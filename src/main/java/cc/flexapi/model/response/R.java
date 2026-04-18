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

    private String msg;

    private T data;

    private R() {
    }

    private R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
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
     * @param msg 错误信息
     * @param <T> 响应数据类型
     * @return 响应式R
     */
    public static <T> Mono<R<T>> error(String msg) {
        return Mono.just(errorSync(msg));
    }

    /**
     * 响应式 响应失败
     *
     * @param code 错误码
     * @param msg  错误信息
     * @param <T>  响应数据类型
     * @return 响应式R
     */
    public static <T> Mono<R<T>> error(Integer code, String msg) {
        return Mono.just(errorSync(code, msg));
    }

    /**
     * 响应式 响应失败
     *
     * @param status 错误码
     * @param msg    错误信息
     * @param <T>    响应数据类型
     * @return 响应式R
     */
    private static <T> Mono<R<T>> error(HttpStatus status, String msg) {
        return Mono.just(errorSync(status, msg));
    }

    private static <T> R<T> errorSync(String msg) {
        R<T> r = new R<>();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

    private static <T> R<T> errorSync(HttpStatus status, String msg) {
        R<T> r = new R<>();
        r.setCode(status.value());
        r.setMsg(msg);
        return r;
    }

    private static <T> R<T> errorSync(Integer code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    private static <T> R<T> okSync() {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("操作成功");
        return r;
    }

    private static <T> R<T> okSync(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

}
