package cc.flexapi.model.po;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * users 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("users")
public class UserPo {

    /**
     * 用户ID
     */
    @Id
    @Column("id")
    @Schema(description = "用户ID")
    private Long id;

    /**
     * 用户名
     */
    @Column("username")
    @Schema(description = "用户名")
    private String username;

    /**
     * 密码
     */
    @Column("password")
    @Schema(description = "密码")
    private String password;

    /**
     * 显示名称
     */
    @Column("display_name")
    @Schema(description = "显示名称")
    private String displayName;

    /**
     * 角色
     */
    @Column("role")
    @Schema(description = "角色")
    private Integer role;

    /**
     * 状态
     */
    @Column("status")
    @Schema(description = "状态")
    private Integer status;

    /**
     * 邮箱
     */
    @Column("email")
    @Schema(description = "邮箱")
    private String email;

    /**
     * GitHub ID
     */
    @Column("github_id")
    @Schema(description = "GitHub ID")
    private String githubId;

    /**
     * Discord ID
     */
    @Column("discord_id")
    @Schema(description = "Discord ID")
    private String discordId;

    /**
     * OIDC ID
     */
    @Column("oidc_id")
    @Schema(description = "OIDC ID")
    private String oidcId;

    /**
     * 微信 ID
     */
    @Column("wechat_id")
    @Schema(description = "微信 ID")
    private String wechatId;

    /**
     * Telegram ID
     */
    @Column("telegram_id")
    @Schema(description = "Telegram ID")
    private String telegramId;

    /**
     * 访问令牌
     */
    @Column("access_token")
    @Schema(description = "访问令牌")
    private String accessToken;

    /**
     * 额度
     */
    @Column("quota")
    @Schema(description = "额度")
    private Long quota;

    /**
     * 已用额度
     */
    @Column("used_quota")
    @Schema(description = "已用额度")
    private Long usedQuota;

    /**
     * 请求次数
     */
    @Column("request_count")
    @Schema(description = "请求次数")
    private Long requestCount;

    /**
     * 分组
     */
    @Column("group")
    @Schema(description = "分组")
    private String group;

    /**
     * 邀请码
     */
    @Column("aff_code")
    @Schema(description = "邀请码")
    private String affCode;

    /**
     * 邀请人数
     */
    @Column("aff_count")
    @Schema(description = "邀请人数")
    private Long affCount;

    /**
     * 邀请额度
     */
    @Column("aff_quota")
    @Schema(description = "邀请额度")
    private Long affQuota;

    /**
     * 历史额度
     */
    @Column("aff_history")
    private Long affHistory;

    /**
     * 邀请id
     */
    @Column("inviter_id")
    @Schema(description = "邀请id")
    private Long inviterId;

    /**
     * 删除时间
     */
    @Column("deleted_at")
    @Schema(description = "删除时间")
    private OffsetDateTime deletedAt;

    /**
     * LinuxDo ID
     */
    @Column("linux_do_id")
    @Schema(description = "LinuxDo ID")
    private String linuxDoId;

    /**
     * 设置 (JSON)
     */
    @Column("setting")
    @Schema(description = "设置 (JSON)")
    private String setting;

    /**
     * 备注
     */
    @Column("remark")
    @Schema(description = "备注")
    private String remark;

    /**
     * stripe 客户
     */
    @Column("stripe_customer")
    @Schema(description = "stripe 客户")
    private String stripeCustomer;

}
