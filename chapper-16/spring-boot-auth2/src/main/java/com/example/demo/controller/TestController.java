package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 * @author ay
 * @since 2020-10-16
 */
@RestController
public class TestController {

    @RequestMapping("/index")
    public void index() {
        System.out.println("index");
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println("test");
    }
}
