package cc.flexapi.service.impl;

import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import cc.flexapi.mapper.ManagementMapper;
import cc.flexapi.model.request.UserManageRequest;
import cc.flexapi.model.response.P;
import cc.flexapi.service.ManagementService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    private ManagementMapper managementMapper;

    @Autowired
    private R2dbcEntityTemplate r2dbcEntityTemplate;
    @Override
    public Mono<Void> addUser(UsersManagerDTO usersManagerDTO) {

        if (usersManagerDTO.getUsername() == null){
            throw new RuntimeException("用户名不能为空");
        }
        if (usersManagerDTO.getPassword() == null){
            throw new RuntimeException("密码不能为空");
        }
        // 在 ManagementServiceImpl 中



        Users users = new Users();
        BeanUtils.copyProperties(usersManagerDTO,users);
        users.setRole(2);
        users.setStatus(1);
        users.setQuota(0);
        users.setUsedQuota(0);
        users.setRequestCount(0);
        users.setUser_group("default");
        Mono<Void> insertUser = managementMapper.insertUser(users.getUsername(),users.getPassword(),users.getDisplayName(),users.getRemark(),users.getQuota(),users.getRole(),users.getStatus());
        return Mono.empty().then(insertUser);
    }

    @Override
    public Mono<Void> deleteById(Integer id) {

        LocalDateTime now = LocalDateTime.now();

        managementMapper.deleteById(id, now);
        return Mono.empty();


    }

    @Override
    public Mono disableUser(Integer id) {
        managementMapper.disableUser(id);
        return Mono.empty();
    }


    @Override
    public Mono<Void> enableUser(Integer id) {
        managementMapper.enableUser(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> promoteById(Integer id) {
        Users users = managementMapper.getUsersById(id);
        if (users.getRole() == 1){
            throw new RuntimeException("已经是管理员");
        }

        if (users == null){
            throw new RuntimeException("用户不存在");
        }

        managementMapper.promoteById(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> demoteById(Integer id) {
        Users users = managementMapper.getUsersById(id);
        if (users.getRole() == 2){
            throw new RuntimeException("已经是普通用户");
        }
        if (users == null){
            throw new RuntimeException("用户不存在");
        }
        managementMapper.demoteById(id);
        return Mono.empty();
    }

    @Override
    public Mono<Void> editUser(UsersManagerEditDTO usersManagerEditDTO) {

        Users users = managementMapper.getUsersById(usersManagerEditDTO.getId());
        if (users != null && users.getUsername() != null && users.getPassword() != null){
            if (users.getUsername().equals(usersManagerEditDTO.getUsername()) && users.getPassword().equals(usersManagerEditDTO.getPassword())){
                throw new RuntimeException("密码重复");

            }
            if (users.getUsername().equals(usersManagerEditDTO.getUsername())){
                throw new RuntimeException("用户名已存在");
            }
        }

        Users users1 = new Users();
        BeanUtils.copyProperties(usersManagerEditDTO,users1);
        managementMapper.updateUserInfo(users1.getId(),users1.getUsername(),users1.getPassword(),users1.getDisplayName(),users1.getRemark(),users1.getQuota(),users1.getRole(),users1.getStatus());
        return Mono.empty();
    }


    @Override
    public Mono<Users> findById(String id) {
        return Mono.just(managementMapper.getUsersById(Integer.parseInt(id)));
    }





    /**
     * 更新用户信息
     * 升降职位 禁用启用
     * @param userManageRequest
     */
    @Override
    public void updateUser(UserManageRequest userManageRequest) {


        Users users = managementMapper.getUsersById(userManageRequest.getId());
        if (users == null){
            throw new RuntimeException("用户不存在");
        }
        switch (userManageRequest.getAction()) {
            case "promote":
                managementMapper.promoteById(userManageRequest.getId());
                break;
            case "demote":
                managementMapper.demoteById(userManageRequest.getId());
                break;
            case "disable":
                managementMapper.disableUser(userManageRequest.getId());
                break;
            case "enable":
                managementMapper.enableUser(userManageRequest.getId());
                break;
        }

    }

    @Override
    public void edit(UsersManagerEditDTO usersManagerEditDTO) {
        managementMapper.updateUserInfo(usersManagerEditDTO.getId(), usersManagerEditDTO.getUsername(), usersManagerEditDTO.getPassword(), usersManagerEditDTO.getDisplayName(), usersManagerEditDTO.getEmail(), Math.toIntExact(usersManagerEditDTO.getQuota()), usersManagerEditDTO.getRole(), usersManagerEditDTO.getStatus());
    }

    @Override
    public Flux<Users> findAll() {
        Flux<Users> users =  managementMapper.selectList();

        return users;
    }


    // ... existing code ...


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
    public void removeById(Integer id) {

        managementMapper.deleteById(id);
    }

// ... existing code ...



}
