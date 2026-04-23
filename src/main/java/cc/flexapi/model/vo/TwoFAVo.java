package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description two_fas 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class TwoFAVo {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * is_enabled
     */
    @JsonProperty("is_enabled")
    private Boolean isEnabled;

    /**
     * failed_attempts
     */
    @JsonProperty("failed_attempts")
    private Integer failedAttempts;

    /**
     * locked_until
     */
    @JsonProperty("locked_until")
    private OffsetDateTime lockedUntil;

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
