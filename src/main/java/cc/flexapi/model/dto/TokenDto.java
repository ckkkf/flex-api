package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description tokens 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class TokenDto {

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
     * created_time
     */
    private Long createdTime;

    /**
     * accessed_time
     */
    private Long accessedTime;

    /**
     * -1 means never expired
     */
    private Long expiredTime;

    /**
     * remain_quota
     */
    private Integer remainQuota;

    /**
     * unlimited_quota
     */
    private Boolean unlimitedQuota;

    /**
     * model_limits_enabled
     */
    private Boolean modelLimitsEnabled;

    /**
     * model_limits
     */
    private String modelLimits;

    /**
     * allow_ips
     */
    private String allowIps;

    /**
     * used quota
     */
    private Integer usedQuota;

    /**
     * group
     */
    private String group;

    /**
     * 跨分组重试，仅auto分组有效
     */
    private Boolean crossGroupRetry;

    /**
     * deleted_at
     */
    private OffsetDateTime deletedAt;

}
