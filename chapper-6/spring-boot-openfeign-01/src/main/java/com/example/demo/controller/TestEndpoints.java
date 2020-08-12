package com.example.demo.controller;

import com.example.demo.feign.TestFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ay
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/openfeign/test")
public class TestEndpoints {

    @Autowired
    @Qualifier(value = "testFeignService")
    private TestFeignApi testFeignApi;

    @GetMapping("/hello")
    public String getProduct() {
        return "hello ay!";
    }
}