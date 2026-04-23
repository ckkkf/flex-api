package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description logs 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class LogVo {

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
     * created_at
     */
    @JsonProperty("created_at")
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
    @JsonProperty("token_name")
    private String tokenName;

    /**
     * model_name
     */
    @JsonProperty("model_name")
    private String modelName;

    /**
     * quota
     */
    private Integer quota;

    /**
     * prompt_tokens
     */
    @JsonProperty("prompt_tokens")
    private Integer promptTokens;

    /**
     * completion_tokens
     */
    @JsonProperty("completion_tokens")
    private Integer completionTokens;

    /**
     * use_time
     */
    @JsonProperty("use_time")
    private Integer useTime;

    /**
     * is_stream
     */
    @JsonProperty("is_stream")
    private Boolean isStream;

    /**
     * channel_id
     */
    @JsonProperty("channel")
    private Integer channelId;

    /**
     * channel_name
     */
    @JsonProperty("channel_name")
    private String channelName;

    /**
     * token_id
     */
    @JsonProperty("token_id")
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
    @JsonProperty("request_id")
    private String requestId;

    /**
     * other
     */
    private String other;

}
