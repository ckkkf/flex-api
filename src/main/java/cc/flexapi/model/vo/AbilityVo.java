package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * abilities 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class AbilityVo {

    /**
     * group
     */
    private String group;

    /**
     * model
     */
    private String model;

    /**
     * channel_id
     */
    @JsonProperty("channel_id")
    private Long channelId;

    /**
     * enabled
     */
    private Boolean enabled;

    /**
     * priority
     */
    private Long priority;

    /**
     * weight
     */
    private Long weight;

    /**
     * tag
     */
    private String tag;

}
