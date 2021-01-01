package com.example.ayuserservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 * @author ay
 * @since 2020-12-07
 */
@RestController
public class UserController {

    @RequestMapping(value = "/hello")
    @HystrixCommand(fallbackMethod = "planb", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hello() throws InterruptedException {
        Thread.sleep(2000);
        return "Hello World";
    }
    private String planb() {
        return "Sorry our Systems are busy! try again later.";
    }
}
