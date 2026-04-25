package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * models 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class ModelDto {

    /**
     * id
     */
    private Long id;

    /**
     * model_name
     */
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
    private Long vendorId;

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
    private Long syncOfficial;

    /**
     * created_time
     */
    private Long createdTime;

    /**
     * updated_time
     */
    private Long updatedTime;

    /**
     * deleted_at
     */
    private OffsetDateTime deletedAt;

    /**
     * name_rule
     */
    private Long nameRule;

}
