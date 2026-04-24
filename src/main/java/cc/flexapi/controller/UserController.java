package cc.flexapi.controller;


import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.request.UserManageRequest;
import cc.flexapi.model.response.P;
import cc.flexapi.model.response.R;
import cc.flexapi.model.vo.LoginVo;
import cc.flexapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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
     * @param turnstile 验证码
     * @param request 登录信息
     * @return 登录信息
     */
    @RequestMapping("/login")
    public Mono<R<LoginVo>> login(@RequestParam(required = false, defaultValue = "") String turnstile,
                                  @Valid @RequestBody LoginRequest request) {
        log.debug("【鉴权服务接口】用户登录。username: {}, turnstile: {}", request.getUsername(), turnstile);
        return R.ok(userService.login(turnstile, request));
    }


    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public Mono<R<Users>> getUserById(@PathVariable String id) {
        log.debug("【用户管理服务接口】根据ID查询用户。id: {}", id);
        return R.ok(userService.findById(id));
    }

    /**
     * 添加用户
     *
     * @param usersManagerDTO 用户信息
     * @return void
     */
    @Operation(summary = "添加用户")
    @PostMapping()
    public Mono<R<Void>> addUser(@RequestBody UsersManagerDTO usersManagerDTO) {
        log.debug("【用户管理服务接口】添加用户。username: {}, displayName: {}", usersManagerDTO.getUsername(), usersManagerDTO.getDisplayName());
        return R.ok(userService.addUser(usersManagerDTO));
    }

    /**
     * 硬删除用户
     *
     * @param id 用户ID
     * @return void
     */
    @Operation(summary = "硬删除用户")
    @DeleteMapping("/delete")
    public Mono<R<Void>> deleteUser(@RequestBody Integer id) {
        log.debug("【用户管理服务接口】硬删除用户。id: {}", id);
        return R.ok(userService.removeById(id));
    }

    /**
     * 搜索用户
     *
     * @param query    查询条件
     * @param p        页码
     * @param pageSize 每页数量
     * @return 用户列表
     */
    @Operation(summary = "搜索用户")
    @GetMapping("/search")
    public Mono<P<Users>> searchUser(
            @RequestParam String query, // 将 @RequestBody 改为 @RequestParam
            @RequestParam(defaultValue = "1") Integer p,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        log.debug("【用户管理服务接口】搜索用户。query: {}, p: {}, pageSize: {}", query, p, pageSize);
        return userService.search(query, p, pageSize);
    }


    /**
     * 更新用户信息
     *
     * @param usersManagerEditDTO 用户信息
     * @return void
     */
    @Operation(summary = "更新用户")
    @PutMapping("/edit")
    public Mono<R<Void>> editUser(@RequestBody UsersManagerEditDTO usersManagerEditDTO) {
        log.debug("【用户管理服务接口】编辑用户。id: {}, username: {}, status: {}", usersManagerEditDTO.getId(), usersManagerEditDTO.getUsername(), usersManagerEditDTO.getStatus());
        return R.ok(userService.editUser(usersManagerEditDTO));
    }



    // 移除第 123 到 134 行的所有重复 mapping，替换为以下单个方法：

    @Operation(summary = "用户列表")
    @GetMapping
    public Flux<Users> listUser(
            @RequestParam(value = "p", defaultValue = "1") Integer p,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        log.debug("【用户管理服务接口】获取用户列表。p: {}, pageSize: {}", p, pageSize);
        return userService.listUser(p, pageSize);
    }


    /**
     * 更新用户信息
     *
     * @param userManageRequest 用户信息
     * @return void
     */
    @Operation(summary = "更新用户信息")
    @PutMapping("/update")
    public Mono<R<Void>> updateUser(@RequestBody UserManageRequest userManageRequest) {
        log.debug("【用户管理服务接口】更新用户信息。id: {}, action: {}", userManageRequest.getId(), userManageRequest.getAction());
        return R.ok(userService.updateUser(userManageRequest));
    }


}
