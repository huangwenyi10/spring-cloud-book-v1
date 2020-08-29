package com.example.demo;

import com.example.demo.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：Feign拦截器配置类
 *
 * @author ay
 * @since 2020-08-04
 */
@Configuration
public class FeignInterceptorConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }
}