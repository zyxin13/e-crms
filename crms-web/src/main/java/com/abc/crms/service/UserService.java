package com.abc.crms.service;

import com.abc.crms.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
public interface UserService {
    User getUserById(Integer id);

    Boolean deleteUserById(Integer id);

    User addUser(User user);
}
