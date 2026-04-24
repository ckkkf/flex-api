package cc.flexapi.model.dto;

import lombok.Data;
import java.time.OffsetDateTime;

/**
 * @author ckkk
 * @version 1.0
 * vendors 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class VendorDto {

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * description
     */
    private String description;

    /**
     * icon
     */
    private String icon;

    /**
     * status
     */
    private Integer status;

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
