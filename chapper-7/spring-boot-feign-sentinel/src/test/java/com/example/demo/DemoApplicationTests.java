package com.example.demo;

import com.example.demo.feign.EchoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	private EchoService echoService;

	@Test
	void contextLoads() {
	}

}
