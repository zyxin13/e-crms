package com.abc.crms.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 邹玉鑫 on 2017/3/13.
 */
@RestController
public class IndexController {

    @RequestMapping("/server")
    public String index() {
        return "connect success!";
    }

}
