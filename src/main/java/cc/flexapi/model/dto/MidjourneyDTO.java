package cc.flexapi.model.dto;

import cc.flexapi.model.po.MidjourneyPO;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description midjourneys 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class MidjourneyDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * code
     */
    private Integer code;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * action
     */
    private String action;

    /**
     * mj_id
     */
    private String mjId;

    /**
     * prompt
     */
    private String prompt;

    /**
     * prompt_en
     */
    private String promptEn;

    /**
     * description
     */
    private String description;

    /**
     * state
     */
    private String state;

    /**
     * submit_time
     */
    private Long submitTime;

    /**
     * start_time
     */
    private Long startTime;

    /**
     * finish_time
     */
    private Long finishTime;

    /**
     * image_url
     */
    private String imageUrl;

    /**
     * video_url
     */
    private String videoUrl;

    /**
     * video_urls
     */
    private String videoUrls;

    /**
     * status
     */
    private String status;

    /**
     * progress
     */
    private String progress;

    /**
     * fail_reason
     */
    private String failReason;

    /**
     * channel_id
     */
    private Integer channelId;

    /**
     * quota
     */
    private Integer quota;

    /**
     * buttons
     */
    private String buttons;

    /**
     * properties
     */
    private String properties;

}
