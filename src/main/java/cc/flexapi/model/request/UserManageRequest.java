package cc.flexapi.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data

public class UserManageRequest {


    @NotBlank(message = "用户id不能为空")
    private Integer id;


    @NotBlank(message = "操作不能为空")
    private String action;


}
