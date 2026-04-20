package cc.flexapi.service.impl;

import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.vo.LoginVO;
import cc.flexapi.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @desc ription
 * @since 2026-04-17 23:11
 */
@Service
public class UserServiceImpl implements UserService {

    public Mono<LoginVO> login(String turnstile, LoginRequest request) {
        // TODO 支持turnstile




        return null;
    }

}
