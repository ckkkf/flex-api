package cc.flexapi.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * 登录响应视图对象
 * @since 2026-04-18 11:16
 */
@Data
public class LoginVo {

    /**
     * 用户主键
     */
    private Long id;

    /**
     * 所属分组
     */
    private String group;

    /**
     * 展示名称
     */
    @JsonProperty("display_name")
    private String displayName;

    /**
     * 用户角色
     */
    private Integer role;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 用户名
     */
    private String username;

}
