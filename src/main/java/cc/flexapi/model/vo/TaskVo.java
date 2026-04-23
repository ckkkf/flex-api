package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description tasks 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class TaskVo {

    /**
     * id
     */
    private Long id;

    /**
     * created_at
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * updated_at
     */
    @JsonProperty("updated_at")
    private Long updatedAt;

    /**
     * 第三方id，不一定有/ song id\ Task id
     */
    @JsonProperty("task_id")
    private String taskId;

    /**
     * 平台
     */
    private String platform;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 修正计费用
     */
    private String group;

    /**
     * channel_id
     */
    @JsonProperty("channel_id")
    private Integer channelId;

    /**
     * quota
     */
    private Integer quota;

    /**
     * 任务类型, song, lyrics, description-mode
     */
    private String action;

    /**
     * 任务状态
     */
    private String status;

    /**
     * fail_reason
     */
    @JsonProperty("fail_reason")
    private String failReason;

    /**
     * submit_time
     */
    @JsonProperty("submit_time")
    private Long submitTime;

    /**
     * start_time
     */
    @JsonProperty("start_time")
    private Long startTime;

    /**
     * finish_time
     */
    @JsonProperty("finish_time")
    private Long finishTime;

    /**
     * progress
     */
    private String progress;

    /**
     * properties
     */
    private String properties;

    /**
     * data
     */
    private String data;

}
