package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * vendors 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("vendors")
public class VendorPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Long id;

    /**
     * name
     */
    @Column("name")
    private String name;

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
     * status
     */
    @Column("status")
    private Integer status;

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

}
