package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * tokens 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class TokenVo {

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
    @JsonProperty("created_time")
    private Long createdTime;

    /**
     * accessed_time
     */
    @JsonProperty("accessed_time")
    private Long accessedTime;

    /**
     * -1 means never expired
     */
    @JsonProperty("expired_time")
    private Long expiredTime;

    /**
     * remain_quota
     */
    @JsonProperty("remain_quota")
    private Integer remainQuota;

    /**
     * unlimited_quota
     */
    @JsonProperty("unlimited_quota")
    private Boolean unlimitedQuota;

    /**
     * model_limits_enabled
     */
    @JsonProperty("model_limits_enabled")
    private Boolean modelLimitsEnabled;

    /**
     * model_limits
     */
    @JsonProperty("model_limits")
    private String modelLimits;

    /**
     * allow_ips
     */
    @JsonProperty("allow_ips")
    private String allowIps;

    /**
     * used quota
     */
    @JsonProperty("used_quota")
    private Integer usedQuota;

    /**
     * group
     */
    private String group;

    /**
     * 跨分组重试，仅auto分组有效
     */
    @JsonProperty("cross_group_retry")
    private Boolean crossGroupRetry;

    /**
     * deleted_at
     */
    @JsonProperty("deleted_at")
    private OffsetDateTime deletedAt;

}
