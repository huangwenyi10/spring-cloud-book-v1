package com.example.ayuserapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallBackConfiguration {

    @Bean
    public FeignClientFallback fooClientFallback(){
        return new FeignClientFallback();
    }

}
