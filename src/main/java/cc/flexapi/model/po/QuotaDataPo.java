package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * quota_data 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("quota_data")
public class QuotaDataPo {

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
     * username
     */
    @Column("username")
    private String username;

    /**
     * model_name
     */
    @Column("model_name")
    private String modelName;

    /**
     * created_at
     */
    @Column("created_at")
    private Long createdAt;

    /**
     * token_used
     */
    @Column("token_used")
    private Integer tokenUsed;

    /**
     * count
     */
    @Column("count")
    private Integer count;

    /**
     * quota
     */
    @Column("quota")
    private Integer quota;

}
