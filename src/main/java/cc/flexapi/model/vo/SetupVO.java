package cc.flexapi.model.vo;

import cc.flexapi.model.dto.SetupDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description setups 表视图对象
 * @since 2026-04-21 19:00
 */
@Data
public class SetupVO {

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
    @JsonProperty("initialized_at")
    private Long initializedAt;

}
