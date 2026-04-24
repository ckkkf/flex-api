package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * channels 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("channels")
public class ChannelPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * type
     */
    @Column("type")
    private Integer type;

    /**
     * key
     */
    @Column("key")
    private String key;

    /**
     * open_ai_organization
     */
    @Column("open_ai_organization")
    private String openAiOrganization;

    /**
     * test_model
     */
    @Column("test_model")
    private String testModel;

    /**
     * status
     */
    @Column("status")
    private Integer status;

    /**
     * name
     */
    @Column("name")
    private String name;

    /**
     * weight
     */
    @Column("weight")
    private Integer weight;

    /**
     * created_time
     */
    @Column("created_time")
    private Long createdTime;

    /**
     * test_time
     */
    @Column("test_time")
    private Long testTime;

    /**
     * in milliseconds
     */
    @Column("response_time")
    private Integer responseTime;

    /**
     * base_url
     */
    @Column("base_url")
    private String baseUrl;

    /**
     * other
     */
    @Column("other")
    private String other;

    /**
     * in USD
     */
    @Column("balance")
    private Double balance;

    /**
     * balance_updated_time
     */
    @Column("balance_updated_time")
    private Long balanceUpdatedTime;

    /**
     * models
     */
    @Column("models")
    private String models;

    /**
     * group
     */
    @Column("group")
    private String group;

    /**
     * used_quota
     */
    @Column("used_quota")
    private Long usedQuota;

    /**
     * model_mapping
     */
    @Column("model_mapping")
    private String modelMapping;

    /**
     * status_code_mapping
     */
    @Column("status_code_mapping")
    private String statusCodeMapping;

    /**
     * priority
     */
    @Column("priority")
    private Long priority;

    /**
     * auto_ban
     */
    @Column("auto_ban")
    private Integer autoBan;

    /**
     * other_info
     */
    @Column("other_info")
    private String otherInfo;

    /**
     * tag
     */
    @Column("tag")
    private String tag;

    /**
     * 渠道额外设置
     */
    @Column("setting")
    private String setting;

    /**
     * param_override
     */
    @Column("param_override")
    private String paramOverride;

    /**
     * header_override
     */
    @Column("header_override")
    private String headerOverride;

    /**
     * remark
     */
    @Column("remark")
    private String remark;

    /**
     * channel_info
     */
    @Column("channel_info")
    private String channelInfo;

    /**
     * 其他设置，存储azure版本等不需要检索的信息，详见dto.ChannelOtherSettings
     */
    @Column("settings")
    private String settings;

}
