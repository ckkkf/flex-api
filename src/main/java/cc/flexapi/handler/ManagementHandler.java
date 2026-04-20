package cc.flexapi.handler;

import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import cc.flexapi.model.response.R;
import cc.flexapi.service.ManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ManagementHandler {

    private final ManagementService managementService;

    // GET /api/user/{id}
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        String id = request.pathVariable("id");
        log.debug("准备获取用户: {}", id);
        return managementService.findById(id)
                .map(R::ok)
                .flatMap(this::respondJson)
                .switchIfEmpty(respondJson(R.error("用户不存在")));
    }



    // POST /api/user
    public Mono<ServerResponse> addUser(ServerRequest request) {



        return request.bodyToMono(UsersManagerDTO.class) // 1. 异步读取请求体
                .flatMap(dto -> {
                    // 2. 在流中执行业务逻辑
                    log.debug("准备添加用户: {}", dto.getUsername());
                    return managementService.addUser(dto); // 确保 Service 返回 Mono<R<Void>>
                })
                // 3. 将 Service 返回的 R 对象转换成 ServerResponse
                .flatMap(this::respondJson)
                // 4. 异常处理（可选但推荐）
                .onErrorResume(e -> {
                    log.error("添加用户失败", e);
                    return respondJson(R.error("系统繁忙，请稍后再试"));
                });
    }

    // DELETE /api/user/{id}
    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        try {
            // 1. 获取路径参数
            Integer id = Integer.valueOf(request.pathVariable("id"));
            log.debug("准备删除用户: {}", id);

            // 2. 调用 Service (此时返回的是 Mono<Void>)
            return managementService.deleteById(id)
                    // 3. 只有当 deleteById 成功完成后，才会执行 then 里的逻辑
                    .then(respondJson(R.ok()))
                    // 4. 捕获 Service 层抛出的异常（如用户不存在等）
                    .onErrorResume(e -> respondJson(R.error(e.getMessage())));

        } catch (NumberFormatException e) {
            // 处理 ID 类型不匹配的情况
            return respondJson(R.error("无效的用户ID格式"));
        }
    }

    // PATCH /api/user/{id}/disable
    public Mono<ServerResponse> disableUser(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        log.debug("准备禁用用户: {}", id);
        return managementService.disableUser(id)
                .then(respondJson(R.ok()));
    }

    // PUT /api/user/{id}/edit
    public Mono<ServerResponse> editUser(ServerRequest request) {

        Integer id = Integer.valueOf(request.pathVariable("id"));
        log.debug("准备编辑用户: {}", id);
        return request.bodyToMono(UsersManagerEditDTO.class)
                .flatMap(usersManagerEditDTO -> {
                    log.debug("准备编辑用户: {}", usersManagerEditDTO.getUsername());
                    usersManagerEditDTO.setId(id);
                    return managementService.editUser(usersManagerEditDTO);
                })
                .then(respondJson(R.ok()));
    }

    // PATCH /api/user/{id}/enable
    public Mono<ServerResponse> enableUser(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        log.debug("准备启用用户: {}", id);
        return managementService.enableUser(id)
                .then(respondJson(R.ok()));
    }

    // PATCH /api/user/{id}/promote
    public Mono<ServerResponse> promoteUser(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        log.debug("准备提升用户: {}", id);
        return managementService.promoteById(id)
                .then(respondJson(R.ok()));
    }

    // PATCH /api/user/{id}/demote
    public Mono<ServerResponse> demoteUser(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        log.debug("准备降级用户: {}", id);
        return managementService.demoteById(id)
                .then(respondJson(R.ok()));
    }

    // GET /api/user/{id}/search?query=xxx
    // 搜索接口：支持 ID 或用户名搜索
    public Mono<ServerResponse> searchUser(ServerRequest request) {
        String query = request.queryParam("query").orElse("");

        // 规范日志：如果是搜索，建议打印出搜索关键词
        log.debug("【用户管理服务】搜索用户。参数 query: {}, 操作人ID: {}", query, 1001L);

        return managementService.search(query) // Service 返回 Flux<UserVO>
                .collectList()                // 将流收集为 List，包装进 Mono
                .map(R::ok)                   // 包装为 R 对象，data 属性就是 List
                .flatMap(this::respondJson);
    }

    // 列表查询接口
    public Mono<ServerResponse> listUsers(ServerRequest request) {
        // 1. 获取路径参数

        // 2. 规范日志
        log.debug("【用户管理服务】查询列表");

        // 3. 调用 Service
        // 注意：这里不需要传入 List<Users>，而是传入查询条件（如 adminId）
        return managementService.listUser()
                .collectList() // 关键：这里保证了传给前端的 R.data 是一个 List 集合
                .map(list -> {
                    log.debug("【用户管理服务】查询成功，返回数量: {}", list.size());
                    return R.ok(list);
                })
                .flatMap(this::respondJson)
                .onErrorResume(e -> {
                    log.error("【用户管理服务】获取列表异常: {}", e.getMessage());
                    return respondJson(R.error("查询失败"));
                });
    }
    

    /** 辅助方法：统一设置 JSON 响应头 */
    private Mono<ServerResponse> respondJson(Object body) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body);
    }
}
