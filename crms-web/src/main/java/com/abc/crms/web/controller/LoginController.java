package com.abc.crms.web.controller;

import com.abc.crms.model.User;
import com.abc.crms.service.UserService;
import com.abc.crms.web.bean.Response;
import com.abc.crms.web.bean.vo.UserVo;
import com.abc.crms.web.util.IntegerUtil;
import com.abc.crms.web.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yuxin.zou on 2017/3/22.
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/in", method = RequestMethod.POST)
    public Object login(@RequestBody UserVo vo, HttpServletRequest request) {
        Response response = ResponseUtil.getResponse();
        if (StringUtils.isEmpty(vo.getUsername()) || StringUtils.isEmpty(vo.getPassword())) {
            ResponseUtil.setErrorMsg(response, "用户名或密码不能为空");
            return response;
        }
        User user = new User();
        user.setUsername(vo.getUsername());
        user.setPassword(vo.getPassword());
        Boolean res = userService.login(user);
        if (res == Boolean.FALSE) {
            ResponseUtil.setErrorMsg(response, "用户名或密码错误");
            return response;
        }
        request.getSession().setAttribute("username", vo.getUsername());
        ResponseUtil.setSuccessMsg(response, "登录成功");
        return response;
    }
}
