package cc.flexapi.model.dto;

import cc.flexapi.model.po.UserPO;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description users 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class UserDTO {

    /**
     * id
     */
    private Integer id;

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
    private Integer quota;

    /**
     * used quota
     */
    private Integer usedQuota;

    /**
     * request number
     */
    private Integer requestCount;

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
    private Integer affCount;

    /**
     * 邀请剩余额度
     */
    private Integer affQuota;

    /**
     * 邀请历史额度
     */
    private Integer affHistory;

    /**
     * inviter_id
     */
    private Integer inviterId;

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
