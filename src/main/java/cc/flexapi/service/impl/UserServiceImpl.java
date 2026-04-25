package cc.flexapi.service.impl;

import cc.flexapi.constants.UserConstants;
import cc.flexapi.model.po.UserPo;
import cc.flexapi.model.request.UsersManagerAddRequest;
import cc.flexapi.model.request.UsersManagerEditRequest;
import cc.flexapi.exception.BusinessException;
import cc.flexapi.mapper.UserMapper;
import cc.flexapi.model.mapper.ModelMapper;
import cc.flexapi.model.request.LoginRequest;
import cc.flexapi.model.request.UserManageRequest;
import cc.flexapi.model.response.P;
import cc.flexapi.model.vo.LoginVo;
import cc.flexapi.service.TurnstileService;
import cc.flexapi.service.UserService;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.context.SaReactorHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.Hutool;
import cn.hutool.crypto.digest.BCrypt;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.List;

/**
 * 用户管理服务实现类
 *
 * @author xiaoyi、ckkk
 * @version 1.0
 * @since 2026-04-18 14:10
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private R2dbcEntityTemplate r2dbcEntityTemplate;

    @Resource
    private TurnstileService turnstileService;

    @Override
    public Mono<LoginVo> login(String turnstile, LoginRequest request) {
        return turnstileService.verify(turnstile)
                .flatMap(turnstileResult -> {
                    // 验证turnstile
                    if (!turnstileResult) {
                        return Mono.error(new BusinessException("turnstile验证失败"));
                    }
                    // 查用户
                    return userMapper.findByUsername(request.getUsername());
                })
                .switchIfEmpty((Mono.error(new BusinessException("用户不存在"))))
                .flatMap(userPo -> {
                    // 密码校验
                    if (!BCrypt.checkpw(request.getPassword(),userPo.getPassword())) {
                        return Mono.error(new BusinessException("用户名或密码错误"));
                    }
                    // 状态校验
                    if (!UserConstants.USER_STATUS_NORMAL.equals(userPo.getStatus())) {
                        return Mono.error(new BusinessException("该账户已被禁用"));
                    }
                    if (userPo.getDeletedAt() != null) {
                        return Mono.error(new BusinessException("该账户已被注销"));
                    }
                    // 登录
                    return SaReactorHolder.sync(()->{
                        StpUtil.login(userPo.getId());
                        log.info("[登录成功] 用户名: {}, IP: {}", userPo.getUsername(), SaHolder.getRequest().getHost());
                        return ModelMapper.toVo(userPo, LoginVo.class);
                    });
                });
    }

    @Override
    public Mono<Void> logout() {
        return SaReactorHolder.sync(() -> {
            Long loginId = StpUtil.getLoginIdAsLong();
            StpUtil.logout();
            log.info("[退出登录] loginId: {}", loginId);
            return Boolean.TRUE;
        }).then();
    }

}
