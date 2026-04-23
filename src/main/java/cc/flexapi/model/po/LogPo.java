package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description logs 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("logs")
public class LogPo {

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
     * created_at
     */
    @Column("created_at")
    private Long createdAt;

    /**
     * type
     */
    @Column("type")
    private Integer type;

    /**
     * content
     */
    @Column("content")
    private String content;

    /**
     * username
     */
    @Column("username")
    private String username;

    /**
     * token_name
     */
    @Column("token_name")
    private String tokenName;

    /**
     * model_name
     */
    @Column("model_name")
    private String modelName;

    /**
     * quota
     */
    @Column("quota")
    private Integer quota;

    /**
     * prompt_tokens
     */
    @Column("prompt_tokens")
    private Integer promptTokens;

    /**
     * completion_tokens
     */
    @Column("completion_tokens")
    private Integer completionTokens;

    /**
     * use_time
     */
    @Column("use_time")
    private Integer useTime;

    /**
     * is_stream
     */
    @Column("is_stream")
    private Boolean isStream;

    /**
     * channel_id
     */
    @Column("channel_id")
    private Integer channelId;

    /**
     * channel_name
     */
    @Column("channel_name")
    private String channelName;

    /**
     * token_id
     */
    @Column("token_id")
    private Integer tokenId;

    /**
     * group
     */
    @Column("group")
    private String group;

    /**
     * ip
     */
    @Column("ip")
    private String ip;

    /**
     * request_id
     */
    @Column("request_id")
    private String requestId;

    /**
     * other
     */
    @Column("other")
    private String other;

}
