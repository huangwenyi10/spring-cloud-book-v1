package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello, ay";
    }
}
