package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * checkins 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("checkins")
public class CheckinPo {

    /**
     * id
     */
    @Id
    @Column("id")
    private Long id;

    /**
     * user_id
     */
    @Column("user_id")
    private Long userId;

    /**
     * 格式: YYYY-MM-DD
     */
    @Column("checkin_date")
    private String checkinDate;

    /**
     * quota_awarded
     */
    @Column("quota_awarded")
    private Long quotaAwarded;

    /**
     * created_at
     */
    @Column("created_at")
    private Long createdAt;

}
