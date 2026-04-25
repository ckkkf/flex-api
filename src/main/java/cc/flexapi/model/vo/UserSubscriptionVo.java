package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * user_subscriptions 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class UserSubscriptionVo {

    /**
     * id
     */
    private Long id;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Long userId;

    /**
     * plan_id
     */
    @JsonProperty("plan_id")
    private Long planId;

    /**
     * amount_total
     */
    @JsonProperty("amount_total")
    private Long amountTotal;

    /**
     * amount_used
     */
    @JsonProperty("amount_used")
    private Long amountUsed;

    /**
     * start_time
     */
    @JsonProperty("start_time")
    private Long startTime;

    /**
     * end_time
     */
    @JsonProperty("end_time")
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
    @JsonProperty("last_reset_time")
    private Long lastResetTime;

    /**
     * next_reset_time
     */
    @JsonProperty("next_reset_time")
    private Long nextResetTime;

    /**
     * upgrade_group
     */
    @JsonProperty("upgrade_group")
    private String upgradeGroup;

    /**
     * prev_user_group
     */
    @JsonProperty("prev_user_group")
    private String prevUserGroup;

    /**
     * created_at
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * updated_at
     */
    @JsonProperty("updated_at")
    private Long updatedAt;

}
