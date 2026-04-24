

package cc.flexapi.mapper;

import cc.flexapi.domain.po.Users;
import cc.flexapi.model.po.UserPo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface UserMapper extends ReactiveCrudRepository<Users, Integer> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    Mono<UserPo> findByUsername(String username);

    @Query("UPDATE users SET deleted_at = :now WHERE id = :id")
    Mono<Integer> deleteById(@Param("id") Integer id, @Param("now") LocalDateTime now);

    @Query("UPDATE users SET status = 0 WHERE id = :id")
    Mono<Integer> disableUser(@Param("id") Integer id);

    @Query("UPDATE users SET status = 1 WHERE id = :id")
    Mono<Integer> enableUser(@Param("id") Integer id);

    @Query("UPDATE users SET role = 1 WHERE id = :id")
    Mono<Integer> promoteById(@Param("id") Integer id);

    @Query("UPDATE users SET role = 2 WHERE id = :id")
    Mono<Integer> demoteById(@Param("id") Integer id);

    // 2. 查询多个结果必须返回 Flux<Users>，不能用 List


    // 3. R2DBC 的 @Query 不支持直接解析 DTO 对象内部属性
    // 必须手动拆解参数，或者在 Service 层使用 repository.save(userPO)
    @Query("UPDATE users SET username = :username, display_name = :displayName, " +
            "email = :email, password = :password, quota = :quota, " +
            "role = :role, status = :status WHERE id = :id")
    Mono<Integer> updateUserInfo(
            @Param("id") Integer id,
            @Param("username") String username,
            @Param("displayName") String displayName,
            @Param("email") String email,
            @Param("password") String password,
            @Param("quota") Integer quota,
            @Param("role") Integer role,
            @Param("status") Integer status
    );

    // 4. 插入操作：R2DBC 建议直接使用内置的 save() 方法，除非有特殊 SQL 需求
    @Query("INSERT INTO users (username, display_name, email, password, quota, role, status) " +
            "VALUES (:username, :displayName, :email, :password, :quota, :role, :status)")
    Mono<Void> insertUser(
            @Param("username") String username,
            @Param("displayName") String displayName,
            @Param("email") String email,
            @Param("password") String password,
            @Param("quota") Integer quota,
            @Param("role") Integer role,
            @Param("status") Integer status
    );


    Mono<Users> getUsersById(Integer id);

    @Query("SELECT * FROM users")
    Flux<Users> selectList();
}
