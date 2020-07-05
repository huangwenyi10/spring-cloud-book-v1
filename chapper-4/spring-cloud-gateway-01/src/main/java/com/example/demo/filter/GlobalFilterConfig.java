package com.example.demo.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalFilterConfig {

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }
}
