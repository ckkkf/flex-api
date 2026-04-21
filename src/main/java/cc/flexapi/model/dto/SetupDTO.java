package cc.flexapi.model.dto;

import cc.flexapi.model.po.SetupPO;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description setups 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class SetupDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * version
     */
    private String version;

    /**
     * initialized_at
     */
    private Long initializedAt;

}
