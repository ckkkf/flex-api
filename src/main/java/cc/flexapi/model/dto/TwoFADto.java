package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * two_fas 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class TwoFADto {

    /**
     * id
     */
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * TOTP密钥，不返回给前端
     */
    private String secret;

    /**
     * is_enabled
     */
    private Boolean isEnabled;

    /**
     * failed_attempts
     */
    private Long failedAttempts;

    /**
     * locked_until
     */
    private OffsetDateTime lockedUntil;

    /**
     * last_used_at
     */
    private OffsetDateTime lastUsedAt;

    /**
     * created_at
     */
    private OffsetDateTime createdAt;

    /**
     * updated_at
     */
    private OffsetDateTime updatedAt;

    /**
     * deleted_at
     */
    private OffsetDateTime deletedAt;

}
