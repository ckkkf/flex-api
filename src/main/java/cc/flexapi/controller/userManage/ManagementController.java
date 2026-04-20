package cc.flexapi.controller.userManage;


import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import cc.flexapi.model.response.P;
import cc.flexapi.model.response.R;
import cc.flexapi.service.ManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "用户管理接口")
@Slf4j
public class ManagementController {




    /*
    * @description 添加用户
     */

    @Autowired
    private ManagementService managementService;

    @GetMapping("/:id")
    public Mono<Users> getUserById(@PathVariable String id) {
        // 这里假设调用UserService的方法获取用户，实际需根据业务实现
        return managementService.findById(id);
    }

    // 获取所有用户，返回Flux
    @GetMapping()
    public Flux<P<Users>> getUsers() {
        return managementService.findAll();
    }





    @Operation(summary = "添加用户")
    @PostMapping()
    public Mono<R<Void>> addUser(@RequestBody UsersManagerDTO usersManagerDTO) {

        log.debug("添加用户成功");

        return R.ok(Mono.just("success").then());
    }

    @Operation(summary = "硬删除用户")
    @DeleteMapping("/delete")
    public Mono<R<Void>> deleteUser(@RequestBody Integer id) {
        managementService.removeById(id);

        log.debug("删除用户成功");

        return R.ok(Mono.just("success").then());
    }


    @Operation(summary = "搜索用户")
    @GetMapping("/search")
    public Flux<P<Users>> searchUser(@RequestBody String query, Integer p, Integer pageSize) {
        log.debug("搜索用户成功");
        return managementService.search(query,p,pageSize);




    }



    @Operation(summary = "更新用户")
    @PutMapping("/edit")
    public Mono<R<Void>> editUser(@RequestBody UsersManagerEditDTO usersManagerEditDTO) {

        log.debug("编辑用户成功");
        managementService.edit(usersManagerEditDTO);


        return R.ok(Mono.just("success").then());
    }





}
