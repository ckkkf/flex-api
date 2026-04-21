package cc.flexapi.model.dto;

import cc.flexapi.model.po.ChannelPO;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description channels 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class ChannelDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * type
     */
    private Integer type;

    /**
     * key
     */
    private String key;

    /**
     * open_ai_organization
     */
    private String openAiOrganization;

    /**
     * test_model
     */
    private String testModel;

    /**
     * status
     */
    private Integer status;

    /**
     * name
     */
    private String name;

    /**
     * weight
     */
    private Integer weight;

    /**
     * created_time
     */
    private Long createdTime;

    /**
     * test_time
     */
    private Long testTime;

    /**
     * in milliseconds
     */
    private Integer responseTime;

    /**
     * base_url
     */
    private String baseUrl;

    /**
     * other
     */
    private String other;

    /**
     * in USD
     */
    private Double balance;

    /**
     * balance_updated_time
     */
    private Long balanceUpdatedTime;

    /**
     * models
     */
    private String models;

    /**
     * group
     */
    private String group;

    /**
     * used_quota
     */
    private Long usedQuota;

    /**
     * model_mapping
     */
    private String modelMapping;

    /**
     * status_code_mapping
     */
    private String statusCodeMapping;

    /**
     * priority
     */
    private Long priority;

    /**
     * auto_ban
     */
    private Integer autoBan;

    /**
     * other_info
     */
    private String otherInfo;

    /**
     * tag
     */
    private String tag;

    /**
     * 渠道额外设置
     */
    private String setting;

    /**
     * param_override
     */
    private String paramOverride;

    /**
     * header_override
     */
    private String headerOverride;

    /**
     * remark
     */
    private String remark;

    /**
     * channel_info
     */
    private String channelInfo;

    /**
     * 其他设置，存储azure版本等不需要检索的信息，详见dto.ChannelOtherSettings
     */
    private String settings;

}
