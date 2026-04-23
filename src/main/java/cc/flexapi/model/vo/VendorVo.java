package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description vendors 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class VendorVo {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * description
     */
    private String description;

    /**
     * icon
     */
    private String icon;

    /**
     * status
     */
    private Integer status;

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
