package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ay
 * @since 2020-04-26
 */
@RestController
@RequestMapping("test")
public class HelloController {

    @RequestMapping("/hello")
    public void say() {
        System.out.println("hello ay!!!");
    }
}
