package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//参考文档：
//【1】https://howtodoinjava.com/spring-boot2/oauth2-auth-server/
//【2】http://www.ruanyifeng.com/blog/2019/04/oauth-grant-types.html （OAuth 2.0 的四种方式）
//【3】https://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html （理解OAuth 2.0）
//【4】http://www.rfcreader.com/#rfc6749 （auth2.0 官方文档）
//三个步骤：
//配置资源服务
//配置认证服务
//配置spring security
@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
