package com.example.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    /**
     *  @SentinelResource 注解用来标识资源是否被限流、降级
     * @param name
     * @return
     */
    //该注解的属性sayHello表示资源名。
    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}