package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description two_fas 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("two_fas")
public class TwoFAPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * user_id
     */
    @Column("user_id")
    private Integer userId;

    /**
     * TOTP密钥，不返回给前端
     */
    @Column("secret")
    private String secret;

    /**
     * is_enabled
     */
    @Column("is_enabled")
    private Boolean isEnabled;

    /**
     * failed_attempts
     */
    @Column("failed_attempts")
    private Integer failedAttempts;

    /**
     * locked_until
     */
    @Column("locked_until")
    private OffsetDateTime lockedUntil;

    /**
     * last_used_at
     */
    @Column("last_used_at")
    private OffsetDateTime lastUsedAt;

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

    /**
     * deleted_at
     */
    @Column("deleted_at")
    private OffsetDateTime deletedAt;

}
