package cc.flexapi.service;

import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.request.UserManageRequest;
import cc.flexapi.model.response.P;
import cc.flexapi.model.vo.LoginVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author xiaoyi
 * @version 1.0
 * {@code @description} 用户管理服务接口
 * @since 2026-04-18 14:10
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param usersManagerDTO 个人用户信息
     * @return void
     */
    Mono<Void> addUser(UsersManagerDTO usersManagerDTO);

    /**
     * 修改用户信息
     *
     * @param usersManagerEditDTO 用户信息
     * @return void
     */
    Mono<Void> editUser(UsersManagerEditDTO usersManagerEditDTO);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    Mono<Users> findById(String id);

    /**
     * 修改用户信息
     *
     * @param userManageRequest 用户信息
     * @return void
     */
    Mono<Void> updateUser(UserManageRequest userManageRequest);





    /**
     * 搜索用户
     *
     * @param query    查询条件
     * @param p        页码
     * @param pageSize 每页数量
     * @return 用户信息
     */
    Mono<P<Users>> search(String query, Integer p, Integer pageSize);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> deleteById(Integer id);

    /**
     * 禁用用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> disableUser(Integer id);

    /**
     * 启用用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> enableUser(Integer id);

    /**
     * 提升用户权限
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> promoteById(Integer id);

    /**
     * 降级用户权限
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> demoteById(Integer id);

    /**
     * 登录
     *
     * @param turnstile 验证码
     * @param request   登录信息
     * @return 登录信息
     */
    Mono<LoginVo> login(String turnstile, LoginRequest request);

    /**
     * 物理删除用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> deleteUser(Integer id);

    /**
     * 获取用户列表
     *
     * @param p        页码
     * @param pageSize 每页数量
     * @return 用户列表
     */
    Flux<Users> list(Integer p, Integer pageSize);

}
