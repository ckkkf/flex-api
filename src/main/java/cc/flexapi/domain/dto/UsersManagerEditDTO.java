package cc.flexapi.domain.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsersManagerEditDTO {

    @NotBlank(message = "用户id不能为空")
    private Integer id;

    private String username;


    private String password;

    private String displayName;

    private String email;

    private String remark;

    private Long quota;

    private Integer role;

    private Integer status;



}
