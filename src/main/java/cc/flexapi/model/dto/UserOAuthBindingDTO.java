package cc.flexapi.model.dto;

import cc.flexapi.model.po.UserOAuthBindingPO;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description user_oauth_bindings 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class UserOAuthBindingDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * User ID - one binding per user per provider
     */
    private Integer userId;

    /**
     * Custom OAuth provider ID
     */
    private Integer providerId;

    /**
     * User ID from OAuth provider - one OAuth account per provider
     */
    private String providerUserId;

    /**
     * created_at
     */
    private OffsetDateTime createdAt;

}
