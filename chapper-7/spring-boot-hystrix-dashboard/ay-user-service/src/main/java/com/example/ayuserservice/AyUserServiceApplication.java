package com.example.ayuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 启动类
 * @author ay
 * @since 2020-12-14
 */
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class AyUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyUserServiceApplication.class, args);
    }

}
