package com.example.demo.controller;

import com.example.ayuserapi.UserFeignApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserFeignApi userFeignApi;

    @RequestMapping("/test")
    public String test() {
        String userName = userFeignApi.getUserName();
        return userName;
    }
}
