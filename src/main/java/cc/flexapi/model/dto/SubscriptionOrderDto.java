package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * subscription_orders 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class SubscriptionOrderDto {

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
     * money
     */
    private Double money;

    /**
     * trade_no
     */
    private String tradeNo;

    /**
     * payment_method
     */
    private String paymentMethod;

    /**
     * status
     */
    private String status;

    /**
     * create_time
     */
    private Long createTime;

    /**
     * complete_time
     */
    private Long completeTime;

    /**
     * provider_payload
     */
    private String providerPayload;

}
