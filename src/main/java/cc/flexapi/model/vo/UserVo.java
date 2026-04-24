package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * users 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class UserVo {

    /**
     * id
     */
    private Integer id;

    /**
     * username
     */
    private String username;

    /**
     * display_name
     */
    @JsonProperty("display_name")
    private String displayName;

    /**
     * admin, common
     */
    private Integer role;

    /**
     * enabled, disabled
     */
    private Integer status;

    /**
     * email
     */
    private String email;

    /**
     * github_id
     */
    @JsonProperty("github_id")
    private String githubId;

    /**
     * discord_id
     */
    @JsonProperty("discord_id")
    private String discordId;

    /**
     * oidc_id
     */
    @JsonProperty("oidc_id")
    private String oidcId;

    /**
     * wechat_id
     */
    @JsonProperty("wechat_id")
    private String wechatId;

    /**
     * telegram_id
     */
    @JsonProperty("telegram_id")
    private String telegramId;

    /**
     * quota
     */
    private Integer quota;

    /**
     * used quota
     */
    @JsonProperty("used_quota")
    private Integer usedQuota;

    /**
     * request number
     */
    @JsonProperty("request_count")
    private Integer requestCount;

    /**
     * group
     */
    private String group;

    /**
     * aff_code
     */
    @JsonProperty("aff_code")
    private String affCode;

    /**
     * aff_count
     */
    @JsonProperty("aff_count")
    private Integer affCount;

    /**
     * 邀请剩余额度
     */
    @JsonProperty("aff_quota")
    private Integer affQuota;

    /**
     * 邀请历史额度
     */
    @JsonProperty("aff_history_quota")
    private Integer affHistory;

    /**
     * inviter_id
     */
    @JsonProperty("inviter_id")
    private Integer inviterId;

    /**
     * deleted_at
     */
    @JsonProperty("deleted_at")
    private OffsetDateTime deletedAt;

    /**
     * linux_do_id
     */
    @JsonProperty("linux_do_id")
    private String linuxDoId;

    /**
     * setting
     */
    private String setting;

    /**
     * remark
     */
    private String remark;

    /**
     * stripe_customer
     */
    @JsonProperty("stripe_customer")
    private String stripeCustomer;

}
