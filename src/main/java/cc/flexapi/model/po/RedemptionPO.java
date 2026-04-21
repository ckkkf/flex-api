package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description redemptions 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("redemptions")
public class RedemptionPO {

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
     * key
     */
    @Column("key")
    private String key;

    /**
     * status
     */
    @Column("status")
    private Integer status;

    /**
     * name
     */
    @Column("name")
    private String name;

    /**
     * quota
     */
    @Column("quota")
    private Integer quota;

    /**
     * created_time
     */
    @Column("created_time")
    private Long createdTime;

    /**
     * redeemed_time
     */
    @Column("redeemed_time")
    private Long redeemedTime;

    /**
     * used_user_id
     */
    @Column("used_user_id")
    private Integer usedUserId;

    /**
     * deleted_at
     */
    @Column("deleted_at")
    private OffsetDateTime deletedAt;

    /**
     * 过期时间，0 表示不过期
     */
    @Column("expired_time")
    private Long expiredTime;

}
