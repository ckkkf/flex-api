package cc.flexapi.model.request;

import lombok.Data;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-18 11:08
 */
@Data
public class LoginRequest {

    private String username;

    private String password;
}
