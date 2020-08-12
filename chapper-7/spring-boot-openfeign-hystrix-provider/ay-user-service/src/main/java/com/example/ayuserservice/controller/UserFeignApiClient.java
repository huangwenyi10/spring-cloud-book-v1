package com.example.ayuserservice.controller;

import com.example.ayuserapi.UserFeignApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFeignApiClient implements UserFeignApi {

    @Override
    @RequestMapping("/getUserName")
    public String getUserName() {
        try {
            System.out.println("sleep~~~");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello, ay";
    }
}
