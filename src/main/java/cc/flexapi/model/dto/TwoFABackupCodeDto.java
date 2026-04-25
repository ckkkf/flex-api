package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * two_fa_backup_codes 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class TwoFABackupCodeDto {

    /**
     * id
     */
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * 备用码哈希
     */
    private String codeHash;

    /**
     * is_used
     */
    private Boolean isUsed;

    /**
     * used_at
     */
    private OffsetDateTime usedAt;

    /**
     * created_at
     */
    private OffsetDateTime createdAt;

    /**
     * deleted_at
     */
    private OffsetDateTime deletedAt;

}
