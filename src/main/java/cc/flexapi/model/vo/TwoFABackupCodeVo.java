package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * two_fa_backup_codes 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class TwoFABackupCodeVo {

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
     * is_used
     */
    @JsonProperty("is_used")
    private Boolean isUsed;

    /**
     * used_at
     */
    @JsonProperty("used_at")
    private OffsetDateTime usedAt;

    /**
     * created_at
     */
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    /**
     * deleted_at
     */
    @JsonProperty("deleted_at")
    private OffsetDateTime deletedAt;

}
