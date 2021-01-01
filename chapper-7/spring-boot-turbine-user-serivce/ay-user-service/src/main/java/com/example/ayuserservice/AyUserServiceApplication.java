package com.example.ayuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 启动类
 * @author ay
 * @since 2020-12-14
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
public class AyUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyUserServiceApplication.class, args);
    }

}
