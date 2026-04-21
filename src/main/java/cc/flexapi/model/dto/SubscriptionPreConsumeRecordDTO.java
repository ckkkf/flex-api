package cc.flexapi.model.dto;

import cc.flexapi.model.po.SubscriptionPreConsumeRecordPO;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description subscription_pre_consume_records 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class SubscriptionPreConsumeRecordDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * request_id
     */
    private String requestId;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * user_subscription_id
     */
    private Integer userSubscriptionId;

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
