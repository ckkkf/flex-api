package cc.flexapi.mapper;

import cc.flexapi.model.po.UserPO;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;


/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-21 23:17
 */
public interface UserMapper extends R2dbcRepository<UserPO, Long> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    Mono<UserPO> findByUsername(String username);
}
