package cc.flexapi.domain.dto;


import lombok.Data;

@Data
public class UsersManagerDTO {
    private Integer id;

    private String username;

    private String password;

    private String displayName;

    private String remark;
}
