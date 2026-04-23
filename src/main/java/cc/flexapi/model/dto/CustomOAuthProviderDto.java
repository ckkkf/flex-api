package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description custom_oauth_providers 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class CustomOAuthProviderDto {

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
    private String clientId;

    /**
     * OAuth client secret (not returned to frontend)
     */
    private String clientSecret;

    /**
     * Authorization URL
     */
    private String authorizationEndpoint;

    /**
     * Token exchange URL
     */
    private String tokenEndpoint;

    /**
     * User info URL
     */
    private String userInfoEndpoint;

    /**
     * OAuth scopes
     */
    private String scopes;

    /**
     * User ID field path, e.g., "sub", "id", "data.user.id"
     */
    private String userIdField;

    /**
     * Username field path
     */
    private String usernameField;

    /**
     * Display name field path
     */
    private String displayNameField;

    /**
     * Email field path
     */
    private String emailField;

    /**
     * OIDC discovery endpoint (optional)
     */
    private String wellKnown;

    /**
     * 0=auto, 1=params, 2=header (Basic Auth)
     */
    private Integer authStyle;

    /**
     * JSON policy for access control based on user info
     */
    private String accessPolicy;

    /**
     * Custom error message template when access is denied
     */
    private String accessDeniedMessage;

    /**
     * created_at
     */
    private OffsetDateTime createdAt;

    /**
     * updated_at
     */
    private OffsetDateTime updatedAt;

}
