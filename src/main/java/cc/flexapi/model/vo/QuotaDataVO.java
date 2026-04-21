package cc.flexapi.model.vo;

import cc.flexapi.model.dto.QuotaDataDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description quota_data 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class QuotaDataVO {

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
     * username
     */
    private String username;

    /**
     * model_name
     */
    @JsonProperty("model_name")
    private String modelName;

    /**
     * created_at
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * token_used
     */
    @JsonProperty("token_used")
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
