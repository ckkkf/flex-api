package cc.flexapi.service;

import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 用户管理服务接口 - 响应式版本
 */
public interface ManagementService extends IService<Users> {

    // 返回 Mono<Void> 表示异步任务执行完成，不返回具体数据
    Mono<Void> addUser(UsersManagerDTO usersManagerDTO);

    Mono<Void> deleteById(Integer id);

    Mono<Void> disableUser(Integer id);

    Mono<Void> enableUser(Integer id);

    Mono<Void> promoteById(Integer id);

    Mono<Void> demoteById(Integer id);
    Mono<Void> editUser(UsersManagerEditDTO usersManagerEditDTO);



    // 统一使用你的 Users 实体类
    Mono<Users> findById(String id);


    Flux<Users> search(String query);


    Flux<List<Users>> listUser();
}
