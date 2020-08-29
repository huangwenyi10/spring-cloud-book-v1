package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述：
 * 【1】http://www.spring4all.com/article/1459(网关 Spring-Cloud-Gateway 源码解析)
 * 【2】
 *
 * @author ay
 * @since 2020-04-28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
