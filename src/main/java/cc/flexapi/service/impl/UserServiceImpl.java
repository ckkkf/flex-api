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
import java.util.stream.Collectors;

/**
 * @author xiaoyi、ckkk
 * @version 1.0
 * @description
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
    public Mono<Void> addUser(UsersManagerDTO usersManagerDTO) {

        if (usersManagerDTO.getUsername() == null) {
            throw new RuntimeException("用户名不能为空");
        }
        if (usersManagerDTO.getPassword() == null) {
            throw new RuntimeException("密码不能为空");
        }
        // 在  中
        Users users = new Users();
        BeanUtils.copyProperties(usersManagerDTO, users);
        users.setRole(2);
        users.setStatus(1);
        users.setQuota(0);
        users.setUsedQuota(0);
        users.setRequestCount(0);
        users.setUser_group("default");
        Mono<Void> insertUser = userMapper.insertUser(users.getUsername(), users.getPassword(),
                users.getDisplayName(), users.getRemark(), users.getQuota(), users.getRole(),
                users.getStatus());
        return Mono.empty().then(insertUser);
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        LocalDateTime now = LocalDateTime.now();
        userMapper.deleteById(id, now);
        return Mono.empty();
    }

    @Override
    public Mono disableUser(Integer id) {
        userMapper.disableUser(id);
        return Mono.empty();
    }


    @Override
    public Mono<Void> enableUser(Integer id) {
        userMapper.enableUser(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> promoteById(Integer id) {
        Users users = userMapper.getUsersById(id);
        if (users.getRole() == 1) {
            throw new RuntimeException("已经是管理员");
        }

        if (users == null) {
            throw new RuntimeException("用户不存在");
        }

        userMapper.promoteById(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> demoteById(Integer id) {
        Users users = userMapper.getUsersById(id);
        if (users.getRole() == 2) {
            throw new RuntimeException("已经是普通用户");
        }
        if (users == null) {
            throw new RuntimeException("用户不存在");
        }
        userMapper.demoteById(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> editUser(UsersManagerEditDTO usersManagerEditDTO) {

        Users users = userMapper.getUsersById(usersManagerEditDTO.getId());
        if (users != null && users.getUsername() != null && users.getPassword() != null) {
            if (users.getUsername().equals(usersManagerEditDTO.getUsername()) && users.getPassword().equals(usersManagerEditDTO.getPassword())) {
                throw new RuntimeException("密码重复");

            }
            if (users.getUsername().equals(usersManagerEditDTO.getUsername())) {
                throw new RuntimeException("用户名已存在");
            }
        }

        Users users1 = new Users();
        BeanUtils.copyProperties(usersManagerEditDTO, users1);
        userMapper.updateUserInfo(users1.getId(), users1.getUsername(), users1.getPassword(), users1.getDisplayName(), users1.getRemark(), users1.getQuota(), users1.getRole(), users1.getStatus());
        return Mono.empty();
    }


    @Override
    public Mono<Users> findById(String id) {
        return Mono.just(userMapper.getUsersById(Integer.parseInt(id)));
    }


    /**
     * 更新用户信息
     * 升降职位 禁用启用
     *
     * @param userManageRequest
     * @return
     */
    @Override
    public Mono<Void> updateUser(UserManageRequest userManageRequest) {


        Users users = userMapper.getUsersById(userManageRequest.getId());
        if (users == null) {
            throw new RuntimeException("用户不存在");
        }
        switch (userManageRequest.getAction()) {
            case "promote":
                userMapper.promoteById(userManageRequest.getId());
                break;
            case "demote":
                userMapper.demoteById(userManageRequest.getId());
                break;
            case "disable":
                userMapper.disableUser(userManageRequest.getId());
                break;
            case "enable":
                userMapper.enableUser(userManageRequest.getId());
                break;
        }

        return null;
    }

    @Override
    public Mono<Void> edit(UsersManagerEditDTO usersManagerEditDTO) {
        Mono<Integer> integerMono = userMapper.updateUserInfo(usersManagerEditDTO.getId(), usersManagerEditDTO.getUsername(), usersManagerEditDTO.getPassword(), usersManagerEditDTO.getDisplayName(), usersManagerEditDTO.getEmail(), Math.toIntExact(usersManagerEditDTO.getQuota()), usersManagerEditDTO.getRole(), usersManagerEditDTO.getStatus());
        return null;
    }

    @Override
    public Flux<Users> findAll() {
        Flux<Users> users = userMapper.selectList();

        return users;
    }


    public Mono<P<Users>> search(String query, Integer p, Integer pageSize) {
        // 1. 参数规范化
        int pageNo = Math.max(1, (p == null) ? 1 : p);
        int size = Math.min(Math.max(1, (pageSize == null) ? 20 : pageSize), 100);

        // 2. 初始化基础条件：未删除
        // 在 R2DBC 中，我们通过不断累加 criteria 来构建动态 SQL
        Criteria criteria = Criteria.where("deleted_at").isNull();

        if (query != null && !query.isEmpty()) {
            // 3. 执行你的思路：分割数据
            // 使用正则 \\s+ 可以匹配空格、制表符等
            List<String> keywords = Arrays.stream(query.trim().split("\\s+"))
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            for (String word : keywords) {
                // 4. 针对每个关键词构建“子条件”
                if (word.matches("^\\d+$")) {
                    // 如果是数字：匹配 ID
                    criteria = criteria.and("id").is(Integer.parseInt(word));
                } else if (word.contains("@")) {
                    // 如果是邮箱：匹配 Email
                    criteria = criteria.and("email").is(word);
                } else {
                    // 模糊查询：(username LIKE %word% OR display_name LIKE %word%)
                    String pattern = "%" + word + "%";
                    criteria = criteria.and(
                            Criteria.where("username").like(pattern)
                                    .or("display_name").like(pattern)
                    );
                }
            }
        }

        // 5. 将条件转化为 Query 对象
        Query baseQuery = Query.query(criteria);

        // 6. 响应式并发执行：Count 和 Select 同时发起
        // template 是 R2dbcEntityTemplate
        Mono<Long> totalMono = r2dbcEntityTemplate.count(baseQuery, Users.class);

        Query pageQuery = baseQuery
                .with(PageRequest.of(pageNo - 1, size))
                .sort(Sort.by(Sort.Order.desc("id")));

        Mono<List<Users>> dataMono = r2dbcEntityTemplate.select(pageQuery, Users.class).collectList();

        // 7. 使用 zip 合并结果并封装进 P 对象
        return Mono.zip(dataMono, totalMono)
                .map(tuple -> P.of(
                        tuple.getT1(),  // 数据列表
                        tuple.getT2(),  // 总数
                        (long) pageNo,
                        (long) size
                ));
    }

    @Override
    public Mono<Void> removeById(Integer id) {

        userMapper.deleteById(id);
        return null;
    }

}
