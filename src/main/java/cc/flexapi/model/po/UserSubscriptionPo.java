package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description user_subscriptions 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("user_subscriptions")
public class UserSubscriptionPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * user_id
     */
    @Column("user_id")
    private Integer userId;

    /**
     * plan_id
     */
    @Column("plan_id")
    private Integer planId;

    /**
     * amount_total
     */
    @Column("amount_total")
    private Long amountTotal;

    /**
     * amount_used
     */
    @Column("amount_used")
    private Long amountUsed;

    /**
     * start_time
     */
    @Column("start_time")
    private Long startTime;

    /**
     * end_time
     */
    @Column("end_time")
    private Long endTime;

    /**
     * active/expired/cancelled
     */
    @Column("status")
    private String status;

    /**
     * order/admin
     */
    @Column("source")
    private String source;

    /**
     * last_reset_time
     */
    @Column("last_reset_time")
    private Long lastResetTime;

    /**
     * next_reset_time
     */
    @Column("next_reset_time")
    private Long nextResetTime;

    /**
     * upgrade_group
     */
    @Column("upgrade_group")
    private String upgradeGroup;

    /**
     * prev_user_group
     */
    @Column("prev_user_group")
    private String prevUserGroup;

    /**
     * created_at
     */
    @Column("created_at")
    private Long createdAt;

    /**
     * updated_at
     */
    @Column("updated_at")
    private Long updatedAt;

}
