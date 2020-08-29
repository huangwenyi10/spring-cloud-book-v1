package com.example.ayuserservice.controller;

import com.example.ayuserapi.UserFeignApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：UserFeignApiClient
 *
 * @author ay
 * @since 2020-07-24
 */
@RestController
public class UserFeignApiClient implements UserFeignApi {

    @Override
    @RequestMapping("/getUserName")
    public String getUserName() {
        return "hello, ay";
    }
}
