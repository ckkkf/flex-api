package cc.flexapi.model.vo;

import cc.flexapi.model.dto.SubscriptionOrderDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description subscription_orders 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class SubscriptionOrderVO {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * plan_id
     */
    @JsonProperty("plan_id")
    private Integer planId;

    /**
     * money
     */
    private Double money;

    /**
     * trade_no
     */
    @JsonProperty("trade_no")
    private String tradeNo;

    /**
     * payment_method
     */
    @JsonProperty("payment_method")
    private String paymentMethod;

    /**
     * status
     */
    private String status;

    /**
     * create_time
     */
    @JsonProperty("create_time")
    private Long createTime;

    /**
     * complete_time
     */
    @JsonProperty("complete_time")
    private Long completeTime;

    /**
     * provider_payload
     */
    @JsonProperty("provider_payload")
    private String providerPayload;

}
