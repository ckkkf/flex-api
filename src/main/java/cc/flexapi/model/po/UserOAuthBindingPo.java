package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description user_oauth_bindings 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("user_oauth_bindings")
public class UserOAuthBindingPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * User ID - one binding per user per provider
     */
    @Column("user_id")
    private Integer userId;

    /**
     * Custom OAuth provider ID
     */
    @Column("provider_id")
    private Integer providerId;

    /**
     * User ID from OAuth provider - one OAuth account per provider
     */
    @Column("provider_user_id")
    private String providerUserId;

    /**
     * created_at
     */
    @Column("created_at")
    private OffsetDateTime createdAt;

}
