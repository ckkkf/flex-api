package cc.flexapi.domain.po;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;


@Data
@Schema(description = "用户信息")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    private Integer id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "确认密码 (不存库)")
    private String password;

    @Schema(description = "原始密码")
    private String originalPassword;

    @Schema(description = "显示名称")
    private String displayName;

    @Schema(description = "角色 (1: 管理员, 2: 普通用户)")
    private Integer role;

    @Schema(description = "状态 (1: 正常, 0: 禁用)")
    private Integer status;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "GitHub ID")
    private String githubId;

    @Schema(description = "Discord ID")
    private String discordId;

    @Schema(description = "OIDC ID")
    private String oidcId;

    @Schema(description = "微信 ID")
    private String wechatId;

    @Schema(description = "Telegram ID")
    private String telegramId;

    @Schema(description = "验证码")
    private String verificationCode;

    @Schema(description = "访问令牌")
    private String accessToken;

    @Schema(description = "额度")
    private Integer quota;

    @Schema(description = "已用额度")
    private Integer usedQuota;

    @Schema(description = "请求次数")
    private Integer requestCount;

    @Schema(description = "分组")

    public String user_group;


    @Schema(description = "邀请码")
    private String affCode;

    @Schema(description = "邀请人数")
    private Integer affCount;

    @Schema(description = "邀请额度")
    private Integer affQuota;

    @Schema(description = "删除时间")
    private String deletedAt;

    @Schema(description = "LinuxDo ID")
    private String linuxDoId;

    @Schema(description = "设置 (JSON)")
    private String setting;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "Stripe 客户 ID")
    private String stripeCustomer;
}