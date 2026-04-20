package cc.flexapi.mapper;
import cc.flexapi.domain.po.Users;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ManagementMapper extends BaseMapper<Users> {


    // 软删除
    @Update("update users set deleted_at = #{now} where id = #{id}")
    void deleteById(Integer id, DateTime now);


    // 禁用用户
    @Update("update users set status = 0 where id = #{id}")
    void disableUser(Integer id);

    // 启用用户
    @Update("update users set status = 1 where id = #{id}")
    void enableUser(Integer id);


    // 提升用户
    @Update("update users set role = 1 where id = #{id}")
    void promoteById(Integer id);

    // 降级用户
    @Update("update users set role = 2 where id = #{id}")
    void demoteById(Integer id);


    @Select("select * from users")
    List<Users> listUser();
}
