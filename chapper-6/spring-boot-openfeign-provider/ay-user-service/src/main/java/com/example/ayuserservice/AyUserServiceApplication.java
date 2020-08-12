package com.example.ayuserservice;

import com.example.ayuserapi.GlobalFeignConfiguration;
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
@EnableFeignClients(defaultConfiguration = GlobalFeignConfiguration.class)
public class AyUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyUserServiceApplication.class, args);
	}
}
