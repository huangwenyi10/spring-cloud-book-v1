package com.example.demo.controller;

import com.example.demo.provider.KafkaSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：
 * @author ay
 * @since 2020-08-09
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private KafkaSender kafkaSender;

    @RequestMapping("/send")
    public void test(){
        kafkaSender.send(1L);
    }
}
