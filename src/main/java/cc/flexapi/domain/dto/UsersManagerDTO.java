package cc.flexapi.domain.dto;


import lombok.Data;

@Data
public class UsersManagerDTO {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */

    private String username;

    /**
     * 密码
     */

    private String password;

    /**
     * 昵称
     */

    private String displayName;

    /**
     * 备注
     */

    private String remark;
}
