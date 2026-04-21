package cc.flexapi.model.dto;

import cc.flexapi.model.po.LogPO;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description logs 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class LogDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * created_at
     */
    private Long createdAt;

    /**
     * type
     */
    private Integer type;

    /**
     * content
     */
    private String content;

    /**
     * username
     */
    private String username;

    /**
     * token_name
     */
    private String tokenName;

    /**
     * model_name
     */
    private String modelName;

    /**
     * quota
     */
    private Integer quota;

    /**
     * prompt_tokens
     */
    private Integer promptTokens;

    /**
     * completion_tokens
     */
    private Integer completionTokens;

    /**
     * use_time
     */
    private Integer useTime;

    /**
     * is_stream
     */
    private Boolean isStream;

    /**
     * channel_id
     */
    private Integer channelId;

    /**
     * channel_name
     */
    private String channelName;

    /**
     * token_id
     */
    private Integer tokenId;

    /**
     * group
     */
    private String group;

    /**
     * ip
     */
    private String ip;

    /**
     * request_id
     */
    private String requestId;

    /**
     * other
     */
    private String other;

}
