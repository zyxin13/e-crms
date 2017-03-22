package com.abc.crms.mapper;

import com.abc.crms.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by yuxin.zou on 2017/3/14.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where username = #{username} and password = #{password}")
    List<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Insert("insert into user(nickname, username, password) values(#{nickname}, #{username}, #{password})")
    int insert(User user);
}
