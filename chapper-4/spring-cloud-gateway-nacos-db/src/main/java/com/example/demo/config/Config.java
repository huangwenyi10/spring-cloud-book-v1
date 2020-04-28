package com.example.demo.config;

import com.example.demo.filter.CustomGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：
 *
 * @author ay
 * @since
 */
@Configuration
public class Config {

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }
}
