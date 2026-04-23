package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description midjourneys 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("midjourneys")
public class MidjourneyPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * code
     */
    @Column("code")
    private Integer code;

    /**
     * user_id
     */
    @Column("user_id")
    private Integer userId;

    /**
     * action
     */
    @Column("action")
    private String action;

    /**
     * mj_id
     */
    @Column("mj_id")
    private String mjId;

    /**
     * prompt
     */
    @Column("prompt")
    private String prompt;

    /**
     * prompt_en
     */
    @Column("prompt_en")
    private String promptEn;

    /**
     * description
     */
    @Column("description")
    private String description;

    /**
     * state
     */
    @Column("state")
    private String state;

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
     * image_url
     */
    @Column("image_url")
    private String imageUrl;

    /**
     * video_url
     */
    @Column("video_url")
    private String videoUrl;

    /**
     * video_urls
     */
    @Column("video_urls")
    private String videoUrls;

    /**
     * status
     */
    @Column("status")
    private String status;

    /**
     * progress
     */
    @Column("progress")
    private String progress;

    /**
     * fail_reason
     */
    @Column("fail_reason")
    private String failReason;

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
     * buttons
     */
    @Column("buttons")
    private String buttons;

    /**
     * properties
     */
    @Column("properties")
    private String properties;

}
