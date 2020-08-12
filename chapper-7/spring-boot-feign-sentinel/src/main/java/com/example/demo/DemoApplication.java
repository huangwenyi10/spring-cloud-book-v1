package com.example.demo;

import com.example.demo.feign.EchoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.Resource;

/**
 *
 *
 * @author ay
 * @since 2020-04-21
 */
@SpringBootApplication
@EnableFeignClients
public class DemoApplication {


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
