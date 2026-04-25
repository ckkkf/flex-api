package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * passkey_credentials 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("passkey_credentials")
public class PasskeyCredentialPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Long id;

    /**
     * user_id
     */
    @Column("user_id")
    private Long userId;

    /**
     * base64 encoded
     */
    @Column("credential_id")
    private String credentialId;

    /**
     * base64 encoded
     */
    @Column("public_key")
    private String publicKey;

    /**
     * attestation_type
     */
    @Column("attestation_type")
    private String attestationType;

    /**
     * base64 encoded
     */
    @Column("aaguid")
    private String aaguid;

    /**
     * sign_count
     */
    @Column("sign_count")
    private Long signCount;

    /**
     * clone_warning
     */
    @Column("clone_warning")
    private Boolean cloneWarning;

    /**
     * user_present
     */
    @Column("user_present")
    private Boolean userPresent;

    /**
     * user_verified
     */
    @Column("user_verified")
    private Boolean userVerified;

    /**
     * backup_eligible
     */
    @Column("backup_eligible")
    private Boolean backupEligible;

    /**
     * backup_state
     */
    @Column("backup_state")
    private Boolean backupState;

    /**
     * transports
     */
    @Column("transports")
    private String transports;

    /**
     * attachment
     */
    @Column("attachment")
    private String attachment;

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
