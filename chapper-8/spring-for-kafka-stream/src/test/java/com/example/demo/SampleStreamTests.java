package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Function;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleStreamTests {

	@Autowired
	private InputDestination input;

	@Autowired
	private OutputDestination output;

	@Test
	public void testEmptyConfiguration() {
		this.input.send(new GenericMessage<byte[]>("hello".getBytes()));
		output.receive().getPayload();
	}

	@SpringBootApplication
	@Import(TestChannelBinderConfiguration.class)
	public static class SampleConfiguration {
		@Bean
		public Function<String, String> uppercase() {
			return v -> v.toUpperCase();
		}
	}
}