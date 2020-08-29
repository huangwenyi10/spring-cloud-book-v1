package com.example.demo.feign;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ay
 * @since 2020-04-22
 */
class EchoServiceFallback implements EchoService {

    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback";
    }

}