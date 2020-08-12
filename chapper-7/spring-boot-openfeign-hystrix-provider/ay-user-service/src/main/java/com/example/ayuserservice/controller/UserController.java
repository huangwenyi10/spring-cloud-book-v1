package com.example.ayuserservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/test")
    public String getUserName(){
        return "hello, ay";
    }
}
