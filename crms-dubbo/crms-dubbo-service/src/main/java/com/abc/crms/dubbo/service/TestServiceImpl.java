package com.abc.crms.dubbo.service;

import com.abc.crms.dubbo.api.TestService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by hasee on 2017/4/1.
 */
@Service
public class TestServiceImpl implements TestService {

    public String test(String testText) {
        return "Hello World";
    }
}
