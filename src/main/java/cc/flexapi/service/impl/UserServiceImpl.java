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

    @Override
    public Mono<Void> addUser(UsersManagerAddRequest usersManagerAddRequest) {
        if (usersManagerAddRequest.getUsername() == null) {
            return Mono.error(new BusinessException("用户名不能为空"));
        }
        if (usersManagerAddRequest.getPassword() == null) {
            return Mono.error(new BusinessException("密码不能为空"));
        }

        UserPo users = new UserPo();
        BeanUtils.copyProperties(usersManagerAddRequest, users);
        users.setRole(2);
        users.setStatus(1);
        users.setQuota(0L);
        users.setUsedQuota(0L);
        users.setRequestCount(0L);

        return userMapper.insertUser(
                users.getUsername(),
                users.getDisplayName(),
                users.getEmail(),
                users.getPassword(),
                users.getQuota(),
                users.getRole(),
                users.getStatus());
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        LocalDateTime now = LocalDateTime.now();
        return userMapper.deleteById(id, now).then();
    }

    @Override
    public Mono<Void> disableUser(Long id) {
        return userMapper.disableUser(id).then();
    }

    @Override
    public Mono<Void> enableUser(Long id) {
        return userMapper.enableUser(id).then();
    }

    @Override
    public Mono<Void> promoteById(Long id) {
        return userMapper.getUsersById(id)
                .switchIfEmpty(Mono.error(new BusinessException("用户不存在")))
                .flatMap(users -> {
                    if (users.getRole() == 1) {
                        return Mono.error(new BusinessException("已经是管理员"));
                    }
                    return userMapper.promoteById(id).then();
                });
    }

    @Override
    public Mono<Void> demoteById(Long id) {
        return userMapper.getUsersById(id)
                .switchIfEmpty(Mono.error(new BusinessException("用户不存在")))
                .flatMap(users -> {
                    if (users.getRole() == 2) {
                        return Mono.error(new BusinessException("已经是普通用户"));
                    }
                    return userMapper.demoteById(id).then();
                });
    }

    @Override
    public Mono<Void> editUser(UsersManagerEditRequest usersManagerEditRequest) {
        return userMapper.getUsersById(usersManagerEditRequest.getId())
                .switchIfEmpty(Mono.error(new BusinessException("用户不存在")))
                .flatMap(users -> {
                    if (users.getUsername() != null && users.getPassword() != null) {
                        if (users.getUsername().equals(usersManagerEditRequest.getUsername())
                                && users.getPassword().equals(usersManagerEditRequest.getPassword())) {
                            return Mono.error(new BusinessException("密码重复"));
                        }
                        if (users.getUsername().equals(usersManagerEditRequest.getUsername())) {
                            return Mono.error(new BusinessException("用户名已存在"));
                        }
                    }

                    UserPo users1 = new UserPo();
                    BeanUtils.copyProperties(usersManagerEditRequest, users1);
                    return userMapper.updateUserInfo(
                            users1.getId(),
                            users1.getUsername(),
                            users1.getDisplayName(),
                            users1.getEmail(),
                            users1.getPassword(),
                            users1.getQuota(),
                            users1.getRole(),
                            users1.getStatus()).then();
                });
    }

    @Override
    public Mono<UserPo> findById(String id) {
        return userMapper.getUsersById(Long.parseLong(id));
    }

    /**
     * 更新用户信息
     * 升降职位 禁用启用
     *
     * @param userManageRequest 用户管理请求
     * @return Mono<Void>
     */
    @Override
    public Mono<Void> updateUser(UserManageRequest userManageRequest) {
        return switch (userManageRequest.getAction()) {
            case "promote" -> promoteById(userManageRequest.getId());
            case "demote" -> demoteById(userManageRequest.getId());
            case "disable" -> disableUser(userManageRequest.getId());
            case "enable" -> enableUser(userManageRequest.getId());
            case "delete" -> deleteById(userManageRequest.getId());
            default -> Mono.empty();
        };
    }

    @Override
    public Mono<P<UserPo>> search(String query, Integer p, Integer pageSize) {
        // 1. 参数规范化
        int pageNo = Math.max(1, (p == null) ? 1 : p);
        int size = Math.min(Math.max(1, (pageSize == null) ? 20 : pageSize), 100);

        // 2. 初始化基础条件：未删除
        Criteria criteria = Criteria.where("deleted_at").isNull();

        if (query != null && !query.isEmpty()) {
            // 3. 分割数据
            List<String> keywords = Arrays.stream(query.trim().split("\\s+"))
                    .filter(s -> !s.isEmpty())
                    .toList();

            for (String word : keywords) {
                // 4. 针对每个关键词构建“子条件”
                if (word.matches("^\\d+$")) {
                    criteria = criteria.and("id").is(Integer.parseInt(word));
                } else if (word.contains("@")) {
                    criteria = criteria.and("email").is(word);
                } else {
                    String pattern = "%" + word + "%";
                    criteria = criteria.and(
                            Criteria.where("username").like(pattern)
                                    .or("display_name").like(pattern));
                }
            }
        }

        // 5. 将条件转化为 Query 对象
        Query baseQuery = Query.query(criteria);

        // 6. 响应式并发执行
        Mono<Long> totalMono = r2dbcEntityTemplate.count(baseQuery, UserPo.class);

        Query pageQuery = baseQuery
                .with(PageRequest.of(pageNo - 1, size))
                .sort(Sort.by(Sort.Order.desc("id")));

        Mono<List<UserPo>> dataMono = r2dbcEntityTemplate.select(pageQuery, UserPo.class).collectList();

        // 7. 使用 zip 合并结果并封装进 P 对象
        return Mono.zip(dataMono, totalMono)
                .map(tuple -> P.of(
                        tuple.getT1(), // 数据列表
                        tuple.getT2(), // 总数
                        pageNo,
                        size));
    }

    @Override
    public Mono<Void> removeById(Long id) {
        // Since ReactiveCrudRepository provides Mono<Void> deleteById(ID id),
        // we can cast to our domain if needed, but our custom mapper returns
        // Mono<Long>.
        // However, there is no generic parameter-less deleteById on userMapper except
        // the inherited one that returns Mono<Void>.
        // Looking at the older version it was deleting directly via inherited
        // deleteById(id)
        return userMapper.deleteById(id);
    }
}
