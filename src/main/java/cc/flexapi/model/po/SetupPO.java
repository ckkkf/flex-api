package cc.flexapi.model.po;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author ckkk
 * @version 1.0
 * @description setups 表持久化对象
 * @since 2026-04-21 19:00
 */
@Data
@Table("setups")
public class SetupPO {

    /**
     * id
     */
    @Id
    @Column("id")
    private Integer id;

    /**
     * version
     */
    @Column("version")
    private String version;

    /**
     * initialized_at
     */
    @Column("initialized_at")
    private Long initializedAt;

}
