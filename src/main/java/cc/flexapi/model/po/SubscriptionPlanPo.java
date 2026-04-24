package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * subscription_plans 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("subscription_plans")
public class SubscriptionPlanPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * title
     */
    @Column("title")
    private String title;

    /**
     * subtitle
     */
    @Column("subtitle")
    private String subtitle;

    /**
     * price_amount
     */
    @Column("price_amount")
    private Double priceAmount;

    /**
     * currency
     */
    @Column("currency")
    private String currency;

    /**
     * duration_unit
     */
    @Column("duration_unit")
    private String durationUnit;

    /**
     * duration_value
     */
    @Column("duration_value")
    private Integer durationValue;

    /**
     * custom_seconds
     */
    @Column("custom_seconds")
    private Long customSeconds;

    /**
     * enabled
     */
    @Column("enabled")
    private Boolean enabled;

    /**
     * sort_order
     */
    @Column("sort_order")
    private Integer sortOrder;

    /**
     * stripe_price_id
     */
    @Column("stripe_price_id")
    private String stripePriceId;

    /**
     * creem_product_id
     */
    @Column("creem_product_id")
    private String creemProductId;

    /**
     * max_purchase_per_user
     */
    @Column("max_purchase_per_user")
    private Integer maxPurchasePerUser;

    /**
     * upgrade_group
     */
    @Column("upgrade_group")
    private String upgradeGroup;

    /**
     * total_amount
     */
    @Column("total_amount")
    private Long totalAmount;

    /**
     * quota_reset_period
     */
    @Column("quota_reset_period")
    private String quotaResetPeriod;

    /**
     * quota_reset_custom_seconds
     */
    @Column("quota_reset_custom_seconds")
    private Long quotaResetCustomSeconds;

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
