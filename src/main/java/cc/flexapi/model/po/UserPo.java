package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description users 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("users")
public class UserPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * username
     */
    @Column("username")
    private String username;

    /**
     * password
     */
    @Column("password")
    private String password;

    /**
     * display_name
     */
    @Column("display_name")
    private String displayName;

    /**
     * admin, common
     */
    @Column("role")
    private Integer role;

    /**
     * enabled, disabled
     */
    @Column("status")
    private Integer status;

    /**
     * email
     */
    @Column("email")
    private String email;

    /**
     * github_id
     */
    @Column("github_id")
    private String githubId;

    /**
     * discord_id
     */
    @Column("discord_id")
    private String discordId;

    /**
     * oidc_id
     */
    @Column("oidc_id")
    private String oidcId;

    /**
     * wechat_id
     */
    @Column("wechat_id")
    private String wechatId;

    /**
     * telegram_id
     */
    @Column("telegram_id")
    private String telegramId;

    /**
     * this token is for system management
     */
    @Column("access_token")
    private String accessToken;

    /**
     * quota
     */
    @Column("quota")
    private Integer quota;

    /**
     * used quota
     */
    @Column("used_quota")
    private Integer usedQuota;

    /**
     * request number
     */
    @Column("request_count")
    private Integer requestCount;

    /**
     * group
     */
    @Column("group")
    private String group;

    /**
     * aff_code
     */
    @Column("aff_code")
    private String affCode;

    /**
     * aff_count
     */
    @Column("aff_count")
    private Integer affCount;

    /**
     * 邀请剩余额度
     */
    @Column("aff_quota")
    private Integer affQuota;

    /**
     * 邀请历史额度
     */
    @Column("aff_history")
    private Integer affHistory;

    /**
     * inviter_id
     */
    @Column("inviter_id")
    private Integer inviterId;

    /**
     * deleted_at
     */
    @Column("deleted_at")
    private OffsetDateTime deletedAt;

    /**
     * linux_do_id
     */
    @Column("linux_do_id")
    private String linuxDoId;

    /**
     * setting
     */
    @Column("setting")
    private String setting;

    /**
     * remark
     */
    @Column("remark")
    private String remark;

    /**
     * stripe_customer
     */
    @Column("stripe_customer")
    private String stripeCustomer;

}
