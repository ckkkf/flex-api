package cc.flexapi.model.request;



import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsersManagerEditRequest {

    @NotBlank(message = "用户id不能为空")
    private Long id;

    private String username;


    private String password;

    private String displayName;

    private String email;

    private String remark;

    private Long quota;

    private Integer role;

    private Integer status;

}
