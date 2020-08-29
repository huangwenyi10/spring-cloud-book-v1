package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ay
 * @since 2020-06-27
 */
@RestController
@RequestMapping("/test")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
