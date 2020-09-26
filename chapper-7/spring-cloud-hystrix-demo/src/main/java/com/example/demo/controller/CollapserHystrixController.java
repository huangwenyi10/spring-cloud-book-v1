package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：请求合并
 *
 * @author ay
 * @since 2020/9/13
 */
@RestController
public class CollapserHystrixController {

    @Resource
    private UserService userService;

    @GetMapping("/testCollapser")
    public String testCollapser() throws Exception{
        new Thread(){
            @Override
            public void run() {
                User user = userService.getUserById(1L);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                User user = userService.getUserById(2L);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                User user = userService.getUserById(3L);
            }
        }.start();
        return "操作成功";
    }
}
