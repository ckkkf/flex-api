package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * quota_data 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class QuotaDataDto {

    /**
     * id
     */
    private Long id;

    /**
     * user_id
     */
    private Long userId;

    /**
     * username
     */
    private String username;

    /**
     * model_name
     */
    private String modelName;

    /**
     * created_at
     */
    private Long createdAt;

    /**
     * token_used
     */
    private Long tokenUsed;

    /**
     * count
     */
    private Long count;

    /**
     * quota
     */
    private Long quota;

}
