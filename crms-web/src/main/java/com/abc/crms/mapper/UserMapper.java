package com.abc.crms.mapper;

import com.abc.crms.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yuxin.zou on 2017/3/14.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}
