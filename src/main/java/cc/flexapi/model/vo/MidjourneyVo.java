package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * midjourneys 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class MidjourneyVo {

    /**
     * id
     */
    private Long id;

    /**
     * code
     */
    private Long code;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Long userId;

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
    private Long channelId;

    /**
     * quota
     */
    private Long quota;

    /**
     * buttons
     */
    private String buttons;

    /**
     * properties
     */
    private String properties;

}
