package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description custom_oauth_providers 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("custom_oauth_providers")
public class CustomOAuthProviderPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * Display name, e.g., "GitHub Enterprise"
     */
    @Column("name")
    private String name;

    /**
     * URL identifier, e.g., "github-enterprise"
     */
    @Column("slug")
    private String slug;

    /**
     * Icon name from @lobehub/icons
     */
    @Column("icon")
    private String icon;

    /**
     * Whether this provider is enabled
     */
    @Column("enabled")
    private Boolean enabled;

    /**
     * OAuth client ID
     */
    @Column("client_id")
    private String clientId;

    /**
     * OAuth client secret (not returned to frontend)
     */
    @Column("client_secret")
    private String clientSecret;

    /**
     * Authorization URL
     */
    @Column("authorization_endpoint")
    private String authorizationEndpoint;

    /**
     * Token exchange URL
     */
    @Column("token_endpoint")
    private String tokenEndpoint;

    /**
     * User info URL
     */
    @Column("user_info_endpoint")
    private String userInfoEndpoint;

    /**
     * OAuth scopes
     */
    @Column("scopes")
    private String scopes;

    /**
     * User ID field path, e.g., "sub", "id", "data.user.id"
     */
    @Column("user_id_field")
    private String userIdField;

    /**
     * Username field path
     */
    @Column("username_field")
    private String usernameField;

    /**
     * Display name field path
     */
    @Column("display_name_field")
    private String displayNameField;

    /**
     * Email field path
     */
    @Column("email_field")
    private String emailField;

    /**
     * OIDC discovery endpoint (optional)
     */
    @Column("well_known")
    private String wellKnown;

    /**
     * 0=auto, 1=params, 2=header (Basic Auth)
     */
    @Column("auth_style")
    private Integer authStyle;

    /**
     * JSON policy for access control based on user info
     */
    @Column("access_policy")
    private String accessPolicy;

    /**
     * Custom error message template when access is denied
     */
    @Column("access_denied_message")
    private String accessDeniedMessage;

    /**
     * created_at
     */
    @Column("created_at")
    private OffsetDateTime createdAt;

    /**
     * updated_at
     */
    @Column("updated_at")
    private OffsetDateTime updatedAt;

}
