package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * passkey_credentials 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class PasskeyCredentialVo {

    /**
     * id
     */
    private Long id;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Long userId;

    /**
     * base64 encoded
     */
    @JsonProperty("credential_id")
    private String credentialId;

    /**
     * attestation_type
     */
    @JsonProperty("attestation_type")
    private String attestationType;

    /**
     * base64 encoded
     */
    private String aaguid;

    /**
     * sign_count
     */
    @JsonProperty("sign_count")
    private Long signCount;

    /**
     * clone_warning
     */
    @JsonProperty("clone_warning")
    private Boolean cloneWarning;

    /**
     * user_present
     */
    @JsonProperty("user_present")
    private Boolean userPresent;

    /**
     * user_verified
     */
    @JsonProperty("user_verified")
    private Boolean userVerified;

    /**
     * backup_eligible
     */
    @JsonProperty("backup_eligible")
    private Boolean backupEligible;

    /**
     * backup_state
     */
    @JsonProperty("backup_state")
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
    @JsonProperty("last_used_at")
    private OffsetDateTime lastUsedAt;

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

    /**
     * deleted_at
     */
    @JsonProperty("deleted_at")
    private OffsetDateTime deletedAt;

}
