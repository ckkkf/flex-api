package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * models 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("models")
public class ModelPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * model_name
     */
    @Column("model_name")
    private String modelName;

    /**
     * description
     */
    @Column("description")
    private String description;

    /**
     * icon
     */
    @Column("icon")
    private String icon;

    /**
     * tags
     */
    @Column("tags")
    private String tags;

    /**
     * vendor_id
     */
    @Column("vendor_id")
    private Integer vendorId;

    /**
     * endpoints
     */
    @Column("endpoints")
    private String endpoints;

    /**
     * status
     */
    @Column("status")
    private Integer status;

    /**
     * sync_official
     */
    @Column("sync_official")
    private Integer syncOfficial;

    /**
     * created_time
     */
    @Column("created_time")
    private Long createdTime;

    /**
     * updated_time
     */
    @Column("updated_time")
    private Long updatedTime;

    /**
     * deleted_at
     */
    @Column("deleted_at")
    private OffsetDateTime deletedAt;

    /**
     * name_rule
     */
    @Column("name_rule")
    private Integer nameRule;

}
