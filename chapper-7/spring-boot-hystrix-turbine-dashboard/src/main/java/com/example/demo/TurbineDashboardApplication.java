package com.example.demo;

import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
@EnableHystrixDashboard
public class TurbineDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineDashboardApplication.class, args);
    }

    @Bean
    public Customizer<HystrixCircuitBreakerFactory> customizer() {
        return factory -> factory.configure(builder -> builder.commandProperties(
                HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(2000)), "foo", "bar");
    }
}
