package cc.flexapi.model.vo;

import cc.flexapi.model.dto.UserOAuthBindingDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description user_oauth_bindings 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class UserOAuthBindingVO {

    /**
     * id
     */
    private Integer id;

    /**
     * User ID - one binding per user per provider
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * Custom OAuth provider ID
     */
    @JsonProperty("provider_id")
    private Integer providerId;

    /**
     * User ID from OAuth provider - one OAuth account per provider
     */
    @JsonProperty("provider_user_id")
    private String providerUserId;

    /**
     * created_at
     */
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

}
