package com.ay.oauth2.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：HelloController
 * @author ay
 * @since 2020-10-25
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "Hello Ay";
    }
}
