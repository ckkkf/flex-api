package cc.flexapi.model.po;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * abilities 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("abilities")
public class AbilityPo {

    /**
     * group
     */
    @Column("group")
    private String group;

    /**
     * model
     */
    @Column("model")
    private String model;

    /**
     * channel_id
     */
    @Column("channel_id")
    private Integer channelId;

    /**
     * enabled
     */
    @Column("enabled")
    private Boolean enabled;

    /**
     * priority
     */
    @Column("priority")
    private Long priority;

    /**
     * weight
     */
    @Column("weight")
    private Integer weight;

    /**
     * tag
     */
    @Column("tag")
    private String tag;

}
