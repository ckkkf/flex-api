package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * models 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class ModelVo {

    /**
     * id
     */
    private Integer id;

    /**
     * model_name
     */
    @JsonProperty("model_name")
    private String modelName;

    /**
     * description
     */
    private String description;

    /**
     * icon
     */
    private String icon;

    /**
     * tags
     */
    private String tags;

    /**
     * vendor_id
     */
    @JsonProperty("vendor_id")
    private Integer vendorId;

    /**
     * endpoints
     */
    private String endpoints;

    /**
     * status
     */
    private Integer status;

    /**
     * sync_official
     */
    @JsonProperty("sync_official")
    private Integer syncOfficial;

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

    /**
     * name_rule
     */
    @JsonProperty("name_rule")
    private Integer nameRule;

}
