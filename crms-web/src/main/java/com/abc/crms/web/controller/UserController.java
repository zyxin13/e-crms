package com.abc.crms.web.controller;

import com.abc.crms.model.User;
import com.abc.crms.service.UserService;
import com.abc.crms.web.bean.Response;
import com.abc.crms.web.bean.vo.UserVo;
import com.abc.crms.web.util.IntegerUtil;
import com.abc.crms.web.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Object getUserById_a(@PathVariable String id) {
        Response response = ResponseUtil.getResponse();
        if (!IntegerUtil.isInteger(id)) {
            ResponseUtil.setErrorMsg(response, "id必须为整数");
            return response;
        }
        User user = userService.getUserById(Integer.parseInt(id));
        if (ObjectUtils.isEmpty(user)) {
            ResponseUtil.setErrorMsg(response, "获取失败");
            return response;
        }
        ResponseUtil.setSuccessMsg(response, "获取成功");
        response.addKey("data", user);
        return response;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Object getUserById_b(@RequestParam String id) {
        return getUserById_a(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Object deleteUserById(@PathVariable String id) {
        Response response = ResponseUtil.getResponse();
        if (!IntegerUtil.isInteger(id)) {
            ResponseUtil.setErrorMsg(response, "id必须为整数");
            return response;
        }
        Boolean res = userService.deleteUserById(Integer.parseInt(id));
        if (res == Boolean.FALSE) {
            ResponseUtil.setErrorMsg(response, "删除失败");
            return response;
        }
        ResponseUtil.setSuccessMsg(response, "删除成功");
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addUser(@RequestBody UserVo userVo) {
        Response response = ResponseUtil.getResponse();

        User user = new User();
        user.setNickname(userVo.getNickname());
        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        user = userService.addUser(user);
        if (ObjectUtils.isEmpty(user)) {
            ResponseUtil.setErrorMsg(response, "添加失败");
            return response;
        }
        ResponseUtil.setSuccessMsg(response, "添加成功");
        response.addKey("data", user);
        return response;
    }
}
