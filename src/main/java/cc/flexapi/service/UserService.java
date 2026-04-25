package cc.flexapi.service;

import cc.flexapi.model.po.UserPo;
import cc.flexapi.model.request.UsersManagerAddRequest;
import cc.flexapi.model.request.UsersManagerEditRequest;
import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.request.UserManageRequest;
import cc.flexapi.model.response.P;
import cc.flexapi.model.vo.LoginVo;
import reactor.core.publisher.Mono;

/**
 * @author xiaoyi
 * @version 1.0
 *          用户管理服务接口
 * @since 2026-04-18 14:10
 */
public interface UserService {


    /**
     * 登录
     *
     * @param turnstile 验证码
     * @param request   登录信息
     * @return 登录信息
     */
    Mono<LoginVo> login(String turnstile, LoginRequest request);

    /**
     * 退出登录
     *
     * @return void
     */
    Mono<Void> logout();

    /**
     * 添加用户
     *
     * @param usersManagerAddRequest 用户信息
     * @return void
     */
    Mono<Void> addUser(UsersManagerAddRequest usersManagerAddRequest);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> deleteById(Long id);

    /**
     * 禁用用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> disableUser(Long id);

    /**
     * 启用用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> enableUser(Long id);

    /**
     * 提升用户权限
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> promoteById(Long id);

    /**
     * 降级用户权限
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> demoteById(Long id);

    /**
     * 修改用户信息
     *
     * @param usersManagerEditRequest 用户信息
     * @return void
     */
    Mono<Void> editUser(UsersManagerEditRequest usersManagerEditRequest);

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    Mono<UserPo> findById(String id);

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
    Mono<P<UserPo>> search(String query, Integer p, Integer pageSize);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return void
     */
    Mono<Void> removeById(Long id);


}
