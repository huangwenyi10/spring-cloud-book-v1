package com.example.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ay
 * @since 2020-08-07
 */
@RestController
public class TestController {

    @GetMapping(value = "/hello/{name}")
    @SentinelResource(value = "sayHello")
    public String apiHello(@PathVariable String name) {
        return "hello," + name;
    }
}
