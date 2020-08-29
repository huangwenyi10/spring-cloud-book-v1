package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ay
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/test")
public class EchoController {


    @RequestMapping("/hello")
    public String say() {
        return "hello ay";
    }

}
