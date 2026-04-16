package cc.flexapi.domain.dto;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class UsersManagerEditDTO {

    private Integer id;
    private String username;
    private String password;
    private String displayName;
    private String remark;
    private Integer quota;
    @TableField("\"group\"")
    private String group;


}
