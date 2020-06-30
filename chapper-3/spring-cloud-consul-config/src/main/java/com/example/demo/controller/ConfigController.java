package com.example.demo.controller;
import com.example.demo.config.MySqlComplexConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author ay
 * @since 2020-06-27
 */
@RestController
public class ConfigController {
    @Resource
    private MySqlComplexConfig mySqlComplexConfig;

    @GetMapping(value = "/getHost")
    public String getMysqlHost(){
        return mySqlComplexConfig.getHost();
    }

    @GetMapping(value = "/getUser")
    public String getMysqlUser(){
        MySqlComplexConfig.UserInfo userInfo = mySqlComplexConfig.getUser();
        return userInfo.toString();
    }
}