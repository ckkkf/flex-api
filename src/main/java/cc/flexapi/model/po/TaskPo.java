package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description tasks 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("tasks")
public class TaskPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Long id;

    /**
     * created_at
     */
    @Column("created_at")
    private Long createdAt;

    /**
     * updated_at
     */
    @Column("updated_at")
    private Long updatedAt;

    /**
     * 第三方id，不一定有/ song id\ Task id
     */
    @Column("task_id")
    private String taskId;

    /**
     * 平台
     */
    @Column("platform")
    private String platform;

    /**
     * user_id
     */
    @Column("user_id")
    private Integer userId;

    /**
     * 修正计费用
     */
    @Column("group")
    private String group;

    /**
     * channel_id
     */
    @Column("channel_id")
    private Integer channelId;

    /**
     * quota
     */
    @Column("quota")
    private Integer quota;

    /**
     * 任务类型, song, lyrics, description-mode
     */
    @Column("action")
    private String action;

    /**
     * 任务状态
     */
    @Column("status")
    private String status;

    /**
     * fail_reason
     */
    @Column("fail_reason")
    private String failReason;

    /**
     * submit_time
     */
    @Column("submit_time")
    private Long submitTime;

    /**
     * start_time
     */
    @Column("start_time")
    private Long startTime;

    /**
     * finish_time
     */
    @Column("finish_time")
    private Long finishTime;

    /**
     * progress
     */
    @Column("progress")
    private String progress;

    /**
     * properties
     */
    @Column("properties")
    private String properties;

    /**
     * private_data
     */
    @Column("private_data")
    private String privateData;

    /**
     * data
     */
    @Column("data")
    private String data;

}
