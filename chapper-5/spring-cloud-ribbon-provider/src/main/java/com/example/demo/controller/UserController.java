package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    Environment environment;

    public String getPort() {
        return environment.getProperty("local.server.port");
    }

    @RequestMapping("getName")
    public String getUserName() {
        return "hello, ay" + "-" + getPort();
    }
}
