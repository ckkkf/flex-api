package cc.flexapi.model.vo;

import cc.flexapi.model.dto.MidjourneyDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description midjourneys 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class MidjourneyVO {

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
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * action
     */
    private String action;

    /**
     * mj_id
     */
    @JsonProperty("mj_id")
    private String mjId;

    /**
     * prompt
     */
    private String prompt;

    /**
     * prompt_en
     */
    @JsonProperty("prompt_en")
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
     * image_url
     */
    @JsonProperty("image_url")
    private String imageUrl;

    /**
     * video_url
     */
    @JsonProperty("video_url")
    private String videoUrl;

    /**
     * video_urls
     */
    @JsonProperty("video_urls")
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
    @JsonProperty("fail_reason")
    private String failReason;

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
     * buttons
     */
    private String buttons;

    /**
     * properties
     */
    private String properties;

}
