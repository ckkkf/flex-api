package cc.flexapi.model.dto;

import cc.flexapi.model.po.OptionPO;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description options 表服务传输对象
 * @since 2026-04-21 19:00
 */
@Data
public class OptionDTO {

    /**
     * key
     */
    private String key;

    /**
     * value
     */
    private String value;

}
