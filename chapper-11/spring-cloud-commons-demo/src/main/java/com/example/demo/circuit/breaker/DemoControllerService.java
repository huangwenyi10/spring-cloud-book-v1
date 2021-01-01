package com.example.demo.circuit.breaker;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class DemoControllerService {
    @Resource
    private RestTemplate rest;
    @Resource
    private CircuitBreakerFactory cbFactory;

    public String slow() {
        return cbFactory.create("slow").run(() ->
                rest.getForObject("/slow", String.class), throwable -> "fallback");
    }
}