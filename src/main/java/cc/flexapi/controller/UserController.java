package cc.flexapi.controller;


import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.response.R;
import cc.flexapi.model.vo.LoginVo;
import cc.flexapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author xiaoyi
 * @version 1.0
 * {@code @description}
 * @since 2026-04-18 14:10
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理接口")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     * @param turnstile 验证码
     * @param request   登录信息
     * @return 登录信息
     */
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Mono<R<LoginVo>> login(@RequestParam(required = false, defaultValue = "") String turnstile,
                                  @Valid @RequestBody LoginRequest request) {
        log.debug("【鉴权服务接口】用户登录。username: {}, turnstile: {}", request.getUsername(), turnstile);
        return R.ok(userService.login(turnstile, request));
    }

    /**
     * 用户退出登录
     *
     * @return void
     */
    @Operation(summary = "用户退出登录")
    @GetMapping("/logout")
    public Mono<R<Void>> logout() {
        log.debug("【鉴权服务接口】用户退出登录");
        return R.ok(userService.logout());
    }
}
