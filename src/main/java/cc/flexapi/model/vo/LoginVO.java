package cc.flexapi.model.vo;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-18 11:16
 */
@Data
public class LoginVO {
    private String id;
    private String group;
    private String displayName;
    private String role;
    private String status;
    private String username;
}
