package com.abc.crms.service.impl;

import com.abc.crms.common.MD5Util;
import com.abc.crms.mapper.UserMapper;
import com.abc.crms.model.User;
import com.abc.crms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }

    public Boolean deleteUserById(Integer id) {
        if (id != 0)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public User addUser(User user) {
        user.setId(66);
        user.setPassword(MD5Util.encode(user.getPassword()));
        return user;
    }

}
