package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * subscription_pre_consume_records 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class SubscriptionPreConsumeRecordDto {

    /**
     * id
     */
    private Long id;

    /**
     * request_id
     */
    private String requestId;

    /**
     * user_id
     */
    private Long userId;

    /**
     * user_subscription_id
     */
    private Long userSubscriptionId;

    /**
     * pre_consumed
     */
    private Long preConsumed;

    /**
     * consumed/refunded
     */
    private String status;

    /**
     * created_at
     */
    private Long createdAt;

    /**
     * updated_at
     */
    private Long updatedAt;

}
