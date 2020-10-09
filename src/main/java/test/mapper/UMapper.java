package test.mapper;

import org.apache.ibatis.annotations.Select;
import test.User;

import java.util.List;

/**
 * @Author: wzg
 * @Date: 2020/9/27 9:44 上午
 */

public interface UMapper {
    @Select(" SELECT * FROM user where name = #{name} ")
    List<User> selectByName(String name);
}
