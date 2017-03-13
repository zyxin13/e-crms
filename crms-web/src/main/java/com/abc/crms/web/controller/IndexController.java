package com.abc.crms.web.controller;

import com.abc.crms.web.bean.Response;
import com.abc.crms.web.bean.SimpleResponse;
import com.abc.crms.web.bean.vo.UserVo;
import com.abc.crms.web.util.IntegerUtil;
import com.abc.crms.web.util.ResponseUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 邹玉鑫 on 2017/3/13.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user/{id}")
    public Object getUserById(@PathVariable String id) {
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
}
