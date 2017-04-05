package com.abc.crms.restapi.controller;

import com.abc.crms.dubbo.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hasee on 2017/4/5.
 */
@RestController
public class IndexController {
    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String hello() {
        return testService.test("hello,Spring boot!");
    }
}
