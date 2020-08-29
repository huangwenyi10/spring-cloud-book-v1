package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参考：
 * https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel
 * https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
 * https://github.com/alibaba/Sentinel/releases（sentinel 最新安装包）
 * https://github.com/alibaba/Sentinel/wiki/%E6%8E%A7%E5%88%B6%E5%8F%B0 (Sentinel 控制台文档)
 *
 * @author ay
 * @since 2020-04-22
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
