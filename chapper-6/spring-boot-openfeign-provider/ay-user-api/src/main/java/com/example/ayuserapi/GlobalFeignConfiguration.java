package com.example.ayuserapi;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 全局日志配置
 * @author : ay
 * @since 2020-08-03
 **/
public class GlobalFeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}