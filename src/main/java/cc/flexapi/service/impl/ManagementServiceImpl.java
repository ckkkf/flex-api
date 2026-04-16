package cc.flexapi.service.impl;

import cc.flexapi.domain.dto.UsersManagerDTO;
import cc.flexapi.domain.dto.UsersManagerEditDTO;
import cc.flexapi.domain.po.Users;
import cc.flexapi.mapper.ManagementMapper;
import cc.flexapi.service.ManagementService;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

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
    public Flux<Users> search(String query) {
        return Flux.defer(() -> {
            LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();

            // 使用正则判断是否为纯数字 (ID)
            if (query.matches("^\\d+$")) {
                wrapper.eq(Users::getId, Integer.parseInt(query));
            }
            // 判断是否为邮箱格式
            else if (query.contains("@")) {
                wrapper.eq(Users::getEmail, query);
            }
            // 默认作为用户名或昵称模糊查询
            else {
                wrapper.and(i -> i.like(Users::getUsername, query)
                        .or().like(Users::getDisplayName, query));
            }

            return Flux.fromIterable(this.baseMapper.selectList(wrapper));
        }).subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Flux<List<Users>> listUser() {

        List<Users> users = managementMapper.listUser();

        return Flux.just(users);
    }


}
