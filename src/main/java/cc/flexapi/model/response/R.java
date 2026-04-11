package cc.flexapi.model.response;


import lombok.Data;
import org.springframework.http.HttpStatus;

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

    public R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }

    public static <T> R<T> error(HttpStatus status, String msg) {
        R<T> r = new R<>();
        r.setCode(status.value());
        r.setMsg(msg);
        return r;
    }
    public static <T> R<T> error(Integer code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("操作成功");
        return r;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

}
