package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description subscription_pre_consume_records 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("subscription_pre_consume_records")
public class SubscriptionPreConsumeRecordPO {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * request_id
     */
    @Column("request_id")
    private String requestId;

    /**
     * user_id
     */
    @Column("user_id")
    private Integer userId;

    /**
     * user_subscription_id
     */
    @Column("user_subscription_id")
    private Integer userSubscriptionId;

    /**
     * pre_consumed
     */
    @Column("pre_consumed")
    private Long preConsumed;

    /**
     * consumed/refunded
     */
    @Column("status")
    private String status;

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
