package com.example.demo.controller;

import com.example.demo.message.SendMsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 参考：https://www.jianshu.com/p/fb7d11c7f798
 *
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
        sendMsgProducer.sendMessage("hello ay!");
    }
}
