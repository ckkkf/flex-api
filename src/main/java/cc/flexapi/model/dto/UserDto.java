package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * users 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class UserDto {

    /**
     * id
     */
    private Long id;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * display_name
     */
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
    private String githubId;

    /**
     * discord_id
     */
    private String discordId;

    /**
     * oidc_id
     */
    private String oidcId;

    /**
     * wechat_id
     */
    private String wechatId;

    /**
     * telegram_id
     */
    private String telegramId;

    /**
     * this token is for system management
     */
    private String accessToken;

    /**
     * quota
     */
    private Long quota;

    /**
     * used quota
     */
    private Long usedQuota;

    /**
     * request number
     */
    private Long requestCount;

    /**
     * group
     */
    private String group;

    /**
     * aff_code
     */
    private String affCode;

    /**
     * aff_count
     */
    private Long affCount;

    /**
     * 邀请剩余额度
     */
    private Long affQuota;

    /**
     * 邀请历史额度
     */
    private Long affHistory;

    /**
     * inviter_id
     */
    private Long inviterId;

    /**
     * deleted_at
     */
    private OffsetDateTime deletedAt;

    /**
     * linux_do_id
     */
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
    private String stripeCustomer;

}
