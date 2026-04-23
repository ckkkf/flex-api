package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description prefill_groups 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("prefill_groups")
public class PrefillGroupPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * name
     */
    @Column("name")
    private String name;

    /**
     * type
     */
    @Column("type")
    private String type;

    /**
     * items
     */
    @Column("items")
    private String items;

    /**
     * description
     */
    @Column("description")
    private String description;

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
