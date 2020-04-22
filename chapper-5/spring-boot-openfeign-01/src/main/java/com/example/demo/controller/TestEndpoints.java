package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openfeign/test")
public class TestEndpoints {

    @GetMapping("/hello")
    public String getProduct() {
        return "hello ay!";
    }


}