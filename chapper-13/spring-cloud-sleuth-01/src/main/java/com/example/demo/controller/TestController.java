package com.example.demo.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

/**
 * TestController控制层
 * @author ay
 * @since 2020-08-10
 */
@RestController
public class TestController {

    private static final Logger LOG = Logger.getLogger(TestController.class.getName());

    @RequestMapping("/test")
    public String test(){
        LOG.info("hello.ay");
        return "hello, ay";
    }

}
