package com.example.demo.controller;

import com.example.ayuserapi.Params;
import com.example.ayuserapi.UserFeignApi;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：TestController层
 *
 * @author ay
 * @since 2020-07-24
 */
@RestController
public class TestController {

    @Resource
    private UserFeignApi userFeignApi;

    @RequestMapping("/test")

    public String test() {
        String userName = userFeignApi.getUserName();
        return userName;
    }

    @GetMapping("/springQueryMap")
    public String springQueryMap(){
        Params params = new Params();
        params.setParam1("hello");
        params.setParam2("ay");
        String result = userFeignApi.demoEndpoint(params);
        return result;
    }

    @GetMapping("/getByIds")
    public String getByIds(){
        String result = userFeignApi.getByIds(new Long[]{1L,2L,3L});
        return result;
    }
}
