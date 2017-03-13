package com.abc.crms.service.impl;

import com.abc.crms.common.MD5Util;
import com.abc.crms.model.User;
import com.abc.crms.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
@Service
public class UserServiceImpl implements UserService {
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUsername("user" + id);
        user.setNickname("nick" + id);
        return user;
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
