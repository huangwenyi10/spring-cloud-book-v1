package com.example.demo.controller;

import com.example.demo.message.SendMsgProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ay
 * @since 2020-04-26
 */
@RestController
@RequestMapping("test")
public class HelloController {

    @Resource
    private SendMsgProducer sendMsgProducer;

    @RequestMapping("/send")
    public void send() {
        System.out.println(123);
        sendMsgProducer.sendMessage("hello ay!");
    }

    @RequestMapping("/send2")
    public void send2() {
        sendMsgProducer.sendMessage2("hello ay 2!");
    }

    @RequestMapping("/send4")
    public void send4() {
        sendMsgProducer.sendMessage4();
    }

    @RequestMapping("/send5")
    public void send5() {
        sendMsgProducer.sendMessage5();
    }
}
