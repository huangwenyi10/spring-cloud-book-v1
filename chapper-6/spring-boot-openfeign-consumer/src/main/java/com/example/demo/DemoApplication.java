package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述：入口类
 * @author ay
 * @since 2020-07-24
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.example.ayuserapi"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
