package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/hello")
    public void test() {
        System.out.println("hello");
    }
}
