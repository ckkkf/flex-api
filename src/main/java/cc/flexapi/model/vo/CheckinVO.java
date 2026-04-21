package cc.flexapi.model.vo;

import cc.flexapi.model.dto.CheckinDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description checkins 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class CheckinVO {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * 格式: YYYY-MM-DD
     */
    @JsonProperty("checkin_date")
    private String checkinDate;

    /**
     * quota_awarded
     */
    @JsonProperty("quota_awarded")
    private Integer quotaAwarded;

    /**
     * created_at
     */
    @JsonProperty("created_at")
    private Long createdAt;

}
