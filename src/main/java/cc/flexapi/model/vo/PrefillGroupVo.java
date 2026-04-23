package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description prefill_groups 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class PrefillGroupVo {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * type
     */
    private String type;

    /**
     * items
     */
    private String items;

    /**
     * description
     */
    private String description;

    /**
     * created_time
     */
    @JsonProperty("created_time")
    private Long createdTime;

    /**
     * updated_time
     */
    @JsonProperty("updated_time")
    private Long updatedTime;

    /**
     * deleted_at
     */
    @JsonProperty("deleted_at")
    private OffsetDateTime deletedAt;

}
