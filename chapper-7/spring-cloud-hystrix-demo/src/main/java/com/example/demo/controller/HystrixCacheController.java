package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：HystrixCacheController控制层
 *
 * @author ay
 * @since 2020/9/13
 */
@RestController
public class HystrixCacheController {
    @Resource
    private UserService userService;

    @GetMapping("/testHystrixCache/{id}")
    public String testHystrixCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.getUserCache(id);
        userService.getUserCache(id);
        return "操作成功";
    }

//    @GetMapping("/testHystrixCache/{id}")
//    public String testRemoveHystrixCache(@PathVariable Long id) {
//        userService.getUserCache(id);
//        userService.removeCache(id);
//        userService.getUserCache(id);
//        return "操作成功";
//    }
}
