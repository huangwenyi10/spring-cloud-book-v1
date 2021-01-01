package com.example.demo.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/12/13
 */
@Configuration
public class CustomCircuitBreakerConfig {


    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(50)
            .waitDurationInOpenState(Duration.ofMillis(1000))
            .slidingWindowSize(2)
            .build();


    TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
            .timeoutDuration(Duration.ofSeconds(4))
            .build();

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(
                id -> new Resilience4JConfigBuilder(id)
                        .timeLimiterConfig(timeLimiterConfig)
                        .circuitBreakerConfig(circuitBreakerConfig)
                        .build());
    }

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> specificCustomConfiguration1() {
        return factory -> factory.configure(
                builder -> builder
                .circuitBreakerConfig(circuitBreakerConfig)
                .timeLimiterConfig(timeLimiterConfig)
                .build(),"circuitBreaker");
    }


    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> specificCustomConfiguration2() {
        return factory -> factory.configure(
                builder -> builder
                       .circuitBreakerConfig(circuitBreakerConfig)
                       .timeLimiterConfig(timeLimiterConfig).build(),
                "circuitBreaker1","circuitBreaker2","circuitBreaker3");
    }
}
