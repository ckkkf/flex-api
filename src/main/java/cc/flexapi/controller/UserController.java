package cc.flexapi.controller;

import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.response.R;
import cc.flexapi.model.vo.LoginVO;
import cc.flexapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @description 认证控制器
 * @since 2026-04-11 14:25
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/login")
    public Mono<R<LoginVO>> login(@RequestParam(required = false, defaultValue = "") String turnstile,
                                  @Valid @RequestBody LoginRequest request) {
        log.debug("【鉴权服务接口】用户登陆。username: {}, turnstile: {}", request.getUsername(), turnstile);
        return R.ok(userService.login(turnstile, request));
    }

}
