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


}
