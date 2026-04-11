package cc.flexapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class P<T> implements Serializable {

    private Long pageNo;

    private Long pageSize;

    private List<T> items;

    private Long total;

    public P(List<T> items, long total, long pageNo, long pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.items = items;
        this.total = total;
    }

    public static <T> P<T> of(List<T> items, long total, long pageNo, long pageSize) {
        return new P<T>(items, total, pageNo, pageSize);
    }

    public static <T> P<T> of(long pageNo, long pageSize) {
        return new P<T>(Collections.emptyList(), 0L, pageNo, pageSize);
    }
}
