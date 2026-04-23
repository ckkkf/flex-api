package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description custom_oauth_providers 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class CustomOAuthProviderVo {

    /**
     * id
     */
    private Integer id;

    /**
     * Display name, e.g., "GitHub Enterprise"
     */
    private String name;

    /**
     * URL identifier, e.g., "github-enterprise"
     */
    private String slug;

    /**
     * Icon name from @lobehub/icons
     */
    private String icon;

    /**
     * Whether this provider is enabled
     */
    private Boolean enabled;

    /**
     * OAuth client ID
     */
    @JsonProperty("client_id")
    private String clientId;

    /**
     * Authorization URL
     */
    @JsonProperty("authorization_endpoint")
    private String authorizationEndpoint;

    /**
     * Token exchange URL
     */
    @JsonProperty("token_endpoint")
    private String tokenEndpoint;

    /**
     * User info URL
     */
    @JsonProperty("user_info_endpoint")
    private String userInfoEndpoint;

    /**
     * OAuth scopes
     */
    private String scopes;

    /**
     * User ID field path, e.g., "sub", "id", "data.user.id"
     */
    @JsonProperty("user_id_field")
    private String userIdField;

    /**
     * Username field path
     */
    @JsonProperty("username_field")
    private String usernameField;

    /**
     * Display name field path
     */
    @JsonProperty("display_name_field")
    private String displayNameField;

    /**
     * Email field path
     */
    @JsonProperty("email_field")
    private String emailField;

    /**
     * OIDC discovery endpoint (optional)
     */
    @JsonProperty("well_known")
    private String wellKnown;

    /**
     * 0=auto, 1=params, 2=header (Basic Auth)
     */
    @JsonProperty("auth_style")
    private Integer authStyle;

    /**
     * JSON policy for access control based on user info
     */
    @JsonProperty("access_policy")
    private String accessPolicy;

    /**
     * Custom error message template when access is denied
     */
    @JsonProperty("access_denied_message")
    private String accessDeniedMessage;

    /**
     * created_at
     */
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    /**
     * updated_at
     */
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

}
