package com.example.demo.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: feign配置类
 * @author  ay
 * @since   2020-8-04
 */
@Configuration
public class FeignDecoderConfig {

    @Bean
    public FeignErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}
