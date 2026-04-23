package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description checkins 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class CheckinDto {

    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * 格式: YYYY-MM-DD
     */
    private String checkinDate;

    /**
     * quota_awarded
     */
    private Integer quotaAwarded;

    /**
     * created_at
     */
    private Long createdAt;

}
