package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description subscription_plans 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class SubscriptionPlanVo {

    /**
     * id
     */
    private Integer id;

    /**
     * title
     */
    private String title;

    /**
     * subtitle
     */
    private String subtitle;

    /**
     * price_amount
     */
    @JsonProperty("price_amount")
    private Double priceAmount;

    /**
     * currency
     */
    private String currency;

    /**
     * duration_unit
     */
    @JsonProperty("duration_unit")
    private String durationUnit;

    /**
     * duration_value
     */
    @JsonProperty("duration_value")
    private Integer durationValue;

    /**
     * custom_seconds
     */
    @JsonProperty("custom_seconds")
    private Long customSeconds;

    /**
     * enabled
     */
    private Boolean enabled;

    /**
     * sort_order
     */
    @JsonProperty("sort_order")
    private Integer sortOrder;

    /**
     * stripe_price_id
     */
    @JsonProperty("stripe_price_id")
    private String stripePriceId;

    /**
     * creem_product_id
     */
    @JsonProperty("creem_product_id")
    private String creemProductId;

    /**
     * max_purchase_per_user
     */
    @JsonProperty("max_purchase_per_user")
    private Integer maxPurchasePerUser;

    /**
     * upgrade_group
     */
    @JsonProperty("upgrade_group")
    private String upgradeGroup;

    /**
     * total_amount
     */
    @JsonProperty("total_amount")
    private Long totalAmount;

    /**
     * quota_reset_period
     */
    @JsonProperty("quota_reset_period")
    private String quotaResetPeriod;

    /**
     * quota_reset_custom_seconds
     */
    @JsonProperty("quota_reset_custom_seconds")
    private Long quotaResetCustomSeconds;

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
