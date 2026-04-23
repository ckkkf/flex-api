package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description redemptions 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class RedemptionVo {

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
    @JsonProperty("created_time")
    private Long createdTime;

    /**
     * redeemed_time
     */
    @JsonProperty("redeemed_time")
    private Long redeemedTime;

    /**
     * used_user_id
     */
    @JsonProperty("used_user_id")
    private Integer usedUserId;

    /**
     * deleted_at
     */
    @JsonProperty("deleted_at")
    private OffsetDateTime deletedAt;

    /**
     * 过期时间，0 表示不过期
     */
    @JsonProperty("expired_time")
    private Long expiredTime;

}
