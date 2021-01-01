package com.example.ayuserservice.controller;

import com.example.ayuserapi.Params;
import com.example.ayuserapi.UserFeignApi;
import feign.Param;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

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

    @Override
    @GetMapping(path = "/demo")
    public String demoEndpoint(@SpringQueryMap Params params) {
        System.out.println(params);
        return "success";
    }

    @Override
    @GetMapping(path = "/search/findByIdIn")
    @CollectionFormat(feign.CollectionFormat.CSV)
    public String getByIds(@RequestParam("ids") Long[] ids) {
        return "success";
    }

}
