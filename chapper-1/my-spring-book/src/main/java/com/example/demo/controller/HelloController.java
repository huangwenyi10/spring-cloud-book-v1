package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：控制层类
 * @author ay 
 * @date 2020-04-01
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public void say(){
        //打印信息
        System.out.println("hello ay");
    }
}