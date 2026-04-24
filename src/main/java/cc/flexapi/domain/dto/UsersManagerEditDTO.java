package cc.flexapi.domain.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsersManagerEditDTO {
    /**
     * 用户id
     */

    @NotBlank(message = "用户id不能为空")
    private Integer id;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")

    private String username;
    /**
     * 密码
     */


    private String password;
    /**
     * 显示名称
     */

    private String displayName;
    /**
     * 邮箱
     */

    private String email;
    /**
     * 备注
     */

    private String remark;
    /**
     * 配额
     */

    private Long quota;
    /**
     * 角色
     */

    private Integer role;
    /**
     * 状态
     */

    private Integer status;



}
