package com.example.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author ay
 * @date 2019-03-24
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    @HystrixCommand(fallbackMethod = "fallbackHello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hello() throws InterruptedException {
        //模拟访问超时
        Thread.sleep(3000);
        return "Hello Hystrix";
    }

    @GetMapping("/testHystrixCommand/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod",
                    commandKey = "testHystrixCommand",
                    groupKey = "testHystrixCommandGroup",
                    ignoreExceptions = {NullPointerException.class},
                    threadPoolKey = "hystrixCommandThreadPool")
    public String testHystrixCommand(@PathVariable Long id){
        return "testHystrixCommand";
    }

    /**
     * 请求失败，调用方法
     */
    public String fallbackMethod(){
       //请求失败，自定义失败返回内容
       return "testHystrixCommand Request fails";
    }

    /**
     * 请求失败，调用方法
     */
    private String fallbackHello() {
        return "Request fails. It takes long time to response";
    }
}