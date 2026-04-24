package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * abilities 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class AbilityDto {

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
    private Integer channelId;

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
    private Integer weight;

    /**
     * tag
     */
    private String tag;

}
