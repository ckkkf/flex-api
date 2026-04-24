package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * two_fa_backup_codes 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("two_fa_backup_codes")
public class TwoFABackupCodePo {

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
     * 备用码哈希
     */
    @Column("code_hash")
    private String codeHash;

    /**
     * is_used
     */
    @Column("is_used")
    private Boolean isUsed;

    /**
     * used_at
     */
    @Column("used_at")
    private OffsetDateTime usedAt;

    /**
     * created_at
     */
    @Column("created_at")
    private OffsetDateTime createdAt;

    /**
     * deleted_at
     */
    @Column("deleted_at")
    private OffsetDateTime deletedAt;

}
