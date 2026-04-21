package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description tokens 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("tokens")
public class TokenPO {

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
     * created_time
     */
    @Column("created_time")
    private Long createdTime;

    /**
     * accessed_time
     */
    @Column("accessed_time")
    private Long accessedTime;

    /**
     * -1 means never expired
     */
    @Column("expired_time")
    private Long expiredTime;

    /**
     * remain_quota
     */
    @Column("remain_quota")
    private Integer remainQuota;

    /**
     * unlimited_quota
     */
    @Column("unlimited_quota")
    private Boolean unlimitedQuota;

    /**
     * model_limits_enabled
     */
    @Column("model_limits_enabled")
    private Boolean modelLimitsEnabled;

    /**
     * model_limits
     */
    @Column("model_limits")
    private String modelLimits;

    /**
     * allow_ips
     */
    @Column("allow_ips")
    private String allowIps;

    /**
     * used quota
     */
    @Column("used_quota")
    private Integer usedQuota;

    /**
     * group
     */
    @Column("group")
    private String group;

    /**
     * 跨分组重试，仅auto分组有效
     */
    @Column("cross_group_retry")
    private Boolean crossGroupRetry;

    /**
     * deleted_at
     */
    @Column("deleted_at")
    private OffsetDateTime deletedAt;

}
