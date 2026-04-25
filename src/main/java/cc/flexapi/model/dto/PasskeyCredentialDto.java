package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * passkey_credentials 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class PasskeyCredentialDto {

    /**
     * id
     */
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * base64 encoded
     */
    private String credentialId;

    /**
     * base64 encoded
     */
    private String publicKey;

    /**
     * attestation_type
     */
    private String attestationType;

    /**
     * base64 encoded
     */
    private String aaguid;

    /**
     * sign_count
     */
    private Long signCount;

    /**
     * clone_warning
     */
    private Boolean cloneWarning;

    /**
     * user_present
     */
    private Boolean userPresent;

    /**
     * user_verified
     */
    private Boolean userVerified;

    /**
     * backup_eligible
     */
    private Boolean backupEligible;

    /**
     * backup_state
     */
    private Boolean backupState;

    /**
     * transports
     */
    private String transports;

    /**
     * attachment
     */
    private String attachment;

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
