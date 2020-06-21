package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String echo(){
        return restTemplate.getForObject("http://service-provider/test/hello", String.class);
    }
}
