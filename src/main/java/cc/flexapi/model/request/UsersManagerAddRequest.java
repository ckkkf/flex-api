package cc.flexapi.model.request;


import lombok.Data;

@Data
public class UsersManagerAddRequest {
    private Long id;

    private String username;

    private String password;

    private String displayName;

    private String remark;
}
