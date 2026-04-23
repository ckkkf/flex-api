package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * @description prefill_groups 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class PrefillGroupDto {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * type
     */
    private String type;

    /**
     * items
     */
    private String items;

    /**
     * description
     */
    private String description;

    /**
     * created_time
     */
    private Long createdTime;

    /**
     * updated_time
     */
    private Long updatedTime;

    /**
     * deleted_at
     */
    private OffsetDateTime deletedAt;

}
