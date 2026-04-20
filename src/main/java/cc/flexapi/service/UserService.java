package cc.flexapi.service;

import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.vo.LoginVO;
import reactor.core.publisher.Mono;

/**
 * @author ckkk
 * @version 1.0
 * @desc ription
 * @since 2026-04-17 23:11
 */
public interface UserService {

    Mono<LoginVO> login(String turnstile, LoginRequest request);

}
