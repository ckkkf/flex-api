package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * redemptions 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class RedemptionDto {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * key
     */
    private String key;

    /**
     * status
     */
    private Integer status;

    /**
     * name
     */
    private String name;

    /**
     * quota
     */
    private Integer quota;

    /**
     * created_time
     */
    private Long createdTime;

    /**
     * redeemed_time
     */
    private Long redeemedTime;

    /**
     * used_user_id
     */
    private Integer usedUserId;

    /**
     * deleted_at
     */
    private OffsetDateTime deletedAt;

    /**
     * 过期时间，0 表示不过期
     */
    private Long expiredTime;

}
