package com.example.demo.feign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ay
 * @since 2020-04-20
 */
@RestController
@RequestMapping("/openfeign/test")
public class NameFeignApiImpl implements NameFeignApi {

    @Override
    @RequestMapping("/name")
    public String getName() {
        return "ay";
    }
}
