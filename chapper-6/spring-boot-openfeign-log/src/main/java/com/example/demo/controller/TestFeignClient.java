package com.example.demo.controller;

import com.example.demo.feign.TestFeignApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ay
 * @since 2020-08-03
 */
@RestController
public class TestFeignClient implements TestFeignApi {


    @RequestMapping("/test")
    @Override
    public String test() {
        return "hello,ay!";
    }
}