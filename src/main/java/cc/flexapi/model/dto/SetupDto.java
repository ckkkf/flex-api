package cc.flexapi.model.dto;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * setups 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class SetupDto {

    /**
     * id
     */
    private Long id;

    /**
     * version
     */
    private String version;

    /**
     * initialized_at
     */
    private Long initializedAt;

}
