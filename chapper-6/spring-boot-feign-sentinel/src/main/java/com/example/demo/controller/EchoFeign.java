package com.example.demo.controller;

import com.example.demo.feign.EchoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoFeign implements EchoService {

    @RequestMapping("/{str}")
    @Override
    public String echo(String str) {
        return str;
    }
}
