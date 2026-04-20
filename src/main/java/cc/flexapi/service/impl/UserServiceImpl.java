package cc.flexapi.service.impl;

import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.vo.LoginVO;
import cc.flexapi.service.UserService;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @desc ription
 * @since 2026-04-17 23:11
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    public Mono<LoginVO> login(String turnstile, LoginRequest request) {
        // TODO 校验turnstile

        // 查询用户名

        // 比对密码

        // 调用satoken登陆

        return null;
    }

}
