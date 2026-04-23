package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description user_subscriptions 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class UserSubscriptionDto {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * plan_id
     */
    private Integer planId;

    /**
     * amount_total
     */
    private Long amountTotal;

    /**
     * amount_used
     */
    private Long amountUsed;

    /**
     * start_time
     */
    private Long startTime;

    /**
     * end_time
     */
    private Long endTime;

    /**
     * active/expired/cancelled
     */
    private String status;

    /**
     * order/admin
     */
    private String source;

    /**
     * last_reset_time
     */
    private Long lastResetTime;

    /**
     * next_reset_time
     */
    private Long nextResetTime;

    /**
     * upgrade_group
     */
    private String upgradeGroup;

    /**
     * prev_user_group
     */
    private String prevUserGroup;

    /**
     * created_at
     */
    private Long createdAt;

    /**
     * updated_at
     */
    private Long updatedAt;

}
