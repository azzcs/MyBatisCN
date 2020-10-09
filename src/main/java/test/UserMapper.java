package test;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: wzg
 * @Date: 2020/9/19 9:25 上午
 */
public interface UserMapper {
    List<User> selectById(Integer id);

    @Select(" SELECT * FROM user where name = #{name} ")
    List<User> selectByName(String name);
}
