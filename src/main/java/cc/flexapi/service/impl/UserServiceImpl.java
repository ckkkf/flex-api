package cc.flexapi.service.impl;

import cc.flexapi.constants.UserConstants;
import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
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
import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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
                    if (!userPo.getPassword().equals(request.getPassword())) {
                        return Mono.error(new BusinessException("用户名或密码错误"));
                    }
                    // 状态校验
                    if (UserConstants.USER_STATUS_NORMAL.equals(userPo.getStatus())) {
                        return Mono.error(new BusinessException("该账户已被禁用"));
                    }
                    if (userPo.getDeletedAt() != null) {
                        return Mono.error(new BusinessException("该账户已被注销"));
                    }
                    // 登录
                    StpUtil.login(userPo.getId());
                    log.info("[登录成功] 用户名: {}, IP: {}", userPo.getUsername(), SaHolder.getRequest().getHost());
                    return Mono.just(ModelMapper.toVo(userPo, LoginVo.class));
                });
    }

    @Override
    public Flux<Users> listUser(Integer p, Integer pageSize) {

        return userMapper.selectList();

    }

    @Override
    public Mono<Void> addUser(UsersManagerDTO usersManagerDTO) {
        if (usersManagerDTO.getUsername() == null) {
            return Mono.error(new BusinessException("用户名不能为空"));
        }
        if (usersManagerDTO.getPassword() == null) {
            return Mono.error(new BusinessException("密码不能为空"));
        }

        Users users = new Users();
        BeanUtils.copyProperties(usersManagerDTO, users);
        users.setRole(2);
        users.setStatus(1);
        users.setQuota(0);
        users.setUsedQuota(0);
        users.setRequestCount(0);
        users.setUser_group("default");

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
    public Mono<Void> deleteById(Integer id) {
        LocalDateTime now = LocalDateTime.now();
        return userMapper.deleteById(id, now).then();
    }

    @Override
    public Mono<Void> disableUser(Integer id) {
        return userMapper.disableUser(id).then();
    }

    @Override
    public Mono<Void> enableUser(Integer id) {
        return userMapper.enableUser(id).then();
    }

    @Override
    public Mono<Void> promoteById(Integer id) {
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
    public Mono<Void> demoteById(Integer id) {
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
    public Mono<Void> editUser(UsersManagerEditDTO usersManagerEditDTO) {
        return userMapper.getUsersById(usersManagerEditDTO.getId())
                .switchIfEmpty(Mono.error(new BusinessException("用户不存在")))
                .flatMap(users -> {
                    if (users.getUsername() != null && users.getPassword() != null) {
                        if (users.getUsername().equals(usersManagerEditDTO.getUsername())
                                && users.getPassword().equals(usersManagerEditDTO.getPassword())) {
                            return Mono.error(new BusinessException("密码重复"));
                        }
                        if (users.getUsername().equals(usersManagerEditDTO.getUsername())) {
                            return Mono.error(new BusinessException("用户名已存在"));
                        }
                    }

                    Users users1 = new Users();
                    BeanUtils.copyProperties(usersManagerEditDTO, users1);
                    return userMapper.updateUserInfo(
                            users1.getId(),
                            users1.getUsername(),
                            users1.getDisplayName(),
                            users1.getEmail(),
                            users1.getPassword(),
                            users1.getQuota() == null ? null : Math.toIntExact(users1.getQuota()),
                            users1.getRole(),
                            users1.getStatus()).then();
                });
    }

    @Override
    public Mono<Users> findById(String id) {
        return userMapper.getUsersById(Integer.parseInt(id));
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
    public Mono<P<Users>> search(String query, Integer p, Integer pageSize) {
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
        Mono<Long> totalMono = r2dbcEntityTemplate.count(baseQuery, Users.class);

        Query pageQuery = baseQuery
                .with(PageRequest.of(pageNo - 1, size))
                .sort(Sort.by(Sort.Order.desc("id")));

        Mono<List<Users>> dataMono = r2dbcEntityTemplate.select(pageQuery, Users.class).collectList();

        // 7. 使用 zip 合并结果并封装进 P 对象
        return Mono.zip(dataMono, totalMono)
                .map(tuple -> P.of(
                        tuple.getT1(), // 数据列表
                        tuple.getT2(), // 总数
                        pageNo,
                        size));
    }

    @Override
    public Mono<Void> removeById(Integer id) {

        return userMapper.deleteById(id);
    }
}
