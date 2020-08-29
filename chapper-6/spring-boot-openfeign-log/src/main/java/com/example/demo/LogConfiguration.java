package com.example.demo;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 描述：日志配置
 *
 * @author ay
 * @since 2020-08-03
 */
public class LogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
} 