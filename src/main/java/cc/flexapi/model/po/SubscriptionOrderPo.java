package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description subscription_orders 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("subscription_orders")
public class SubscriptionOrderPo {

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
     * money
     */
    @Column("money")
    private Double money;

    /**
     * trade_no
     */
    @Column("trade_no")
    private String tradeNo;

    /**
     * payment_method
     */
    @Column("payment_method")
    private String paymentMethod;

    /**
     * status
     */
    @Column("status")
    private String status;

    /**
     * create_time
     */
    @Column("create_time")
    private Long createTime;

    /**
     * complete_time
     */
    @Column("complete_time")
    private Long completeTime;

    /**
     * provider_payload
     */
    @Column("provider_payload")
    private String providerPayload;

}
