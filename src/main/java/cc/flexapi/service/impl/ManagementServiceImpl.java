package cc.flexapi.service.impl;

import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import cc.flexapi.mapper.ManagementMapper;
import cc.flexapi.model.request.UserManageRequest;
import cc.flexapi.model.response.P;
import cc.flexapi.service.ManagementService;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Collections;
import java.util.List;

@Service
public class ManagementServiceImpl extends ServiceImpl<ManagementMapper, Users> implements ManagementService {

    @Autowired
    private ManagementMapper managementMapper;
    @Override
    public Mono<Void> addUser(UsersManagerDTO usersManagerDTO) {

        if (usersManagerDTO.getUsername() == null){
            throw new RuntimeException("用户名不能为空");
        }
        if (usersManagerDTO.getPassword() == null){
            throw new RuntimeException("密码不能为空");
        }
        // 在 ManagementServiceImpl 中
        Users existUser = this.getOne(new LambdaQueryWrapper<Users>()
                .eq(Users::getUsername, usersManagerDTO.getUsername()));
        if (existUser != null){
            if (existUser.getPassword() == usersManagerDTO.getPassword()){
                throw new RuntimeException("密码重复");
            }
            throw new RuntimeException("用户名已存在");
        }


        Users users = new Users();
        BeanUtils.copyProperties(usersManagerDTO,users);
        users.setRole(2);
        users.setStatus(1);
        users.setQuota(0);
        users.setUsedQuota(0);
        users.setRequestCount(0);
        users.setUser_group("default");
        managementMapper.insert(users);
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteById(Integer id) {

        DateTime now = DateTime.now();

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
        Users users = managementMapper.selectById(Integer.valueOf(id));
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
        Users users = managementMapper.selectById(id);
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

        Users users = managementMapper.selectById(usersManagerEditDTO.getId());
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
        managementMapper.updateById(users1);
        return Mono.empty();
    }


    @Override
    public Mono<Users> findById(String id) {
        return Mono.just(this.baseMapper.selectById(id));
    }




    @Override
    public Flux<List<Users>> listUser() {

        List<Users> users = managementMapper.listUser();

        return Flux.just(users);
    }

    /**
     * 更新用户信息
     * 升降职位 禁用启用
     * @param userManageRequest
     */
    @Override
    public void updateUser(UserManageRequest userManageRequest) {


        Users users = managementMapper.selectById(userManageRequest.getId());
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
        managementMapper.updateById(usersManagerEditDTO);
    }

    @Override
    public Flux<P<Users>> findAll() {
        managementMapper.selectList();
        return null;
    }




    // ... existing code ...


    public Flux<P<Users>> search(String query, Integer p, Integer pageSize) {
        // 1. Handle defaults
        int current = (p == null || p < 1) ? 1 : p;
        int size = (pageSize == null || pageSize < 1) ? 20 : pageSize;

        return Mono.fromCallable(() -> {
                    LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();

                    // 2. Build Query Logic
                    if (query != null && query.matches("^\\d+$")) {
                        wrapper.eq(Users::getId, Integer.parseInt(query));
                    } else if (query != null && query.contains("@")) {
                        wrapper.eq(Users::getEmail, query);
                    } else if (query != null) {
                        wrapper.and(i -> i.like(Users::getUsername, query)
                                .or().like(Users::getDisplayName, query));
                    }

                    // 3. Use MyBatis-Plus Page object
                    Page<Users> pageParam = new Page<>(current, size);
                    IPage<Users> result = managementMapper.selectPage(pageParam, wrapper);

                    // 4. Map to your custom P wrapper
                    return P.of(result.getRecords(),
                            result.getTotal(),
                            (int) result.getCurrent(),
                            (int) result.getSize());
                })
                .subscribeOn(Schedulers.boundedElastic()) // Vital for JDBC/Blocking IO
                .flux();
    }

// ... existing code ...



}
