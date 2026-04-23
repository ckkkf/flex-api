package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description subscription_pre_consume_records 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class SubscriptionPreConsumeRecordVo {

    /**
     * id
     */
    private Integer id;

    /**
     * request_id
     */
    @JsonProperty("request_id")
    private String requestId;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * user_subscription_id
     */
    @JsonProperty("user_subscription_id")
    private Integer userSubscriptionId;

    /**
     * pre_consumed
     */
    @JsonProperty("pre_consumed")
    private Long preConsumed;

    /**
     * consumed/refunded
     */
    private String status;

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
