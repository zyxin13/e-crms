package com.abc.crms.web.controller;

import com.abc.crms.web.bean.Response;
import com.abc.crms.web.bean.vo.UserVo;
import com.abc.crms.web.util.IntegerUtil;
import com.abc.crms.web.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yuxin.zou on 2017/3/13.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Object getUserById_a(@PathVariable String id) {
        Response response = ResponseUtil.getResponse();
        if (!IntegerUtil.isInteger(id)) {
            ResponseUtil.setErrorMsg(response, "id必须为整数");
            return response;
        }

        UserVo user = new UserVo();
        user.setId(Integer.valueOf(id));
        user.setUsername("user" + id);
        user.setNickname("nick" + id);

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

        UserVo user = new UserVo();
        user.setId(Integer.valueOf(id));
        user.setUsername("user" + id);
        user.setNickname("nick" + id);

        ResponseUtil.setSuccessMsg(response, "删除成功");
        response.addKey("data", user);
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addUser(@RequestBody UserVo user) {
        Response response = ResponseUtil.getResponse();

        user.setId(6);

        ResponseUtil.setSuccessMsg(response, "添加成功");
        response.addKey("data", user);
        return response;
    }
}
