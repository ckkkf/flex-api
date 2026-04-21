package cc.flexapi.model.dto;

import cc.flexapi.model.po.QuotaDataPO;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description quota_data 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class QuotaDataDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    private Integer userId;

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
    private Integer tokenUsed;

    /**
     * count
     */
    private Integer count;

    /**
     * quota
     */
    private Integer quota;

}
