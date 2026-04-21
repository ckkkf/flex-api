package cc.flexapi.model.po;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description options 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("options")
public class OptionPO {

    /**
     * key
     */
    @Column("key")
    private String key;

    /**
     * value
     */
    @Column("value")
    private String value;

}
