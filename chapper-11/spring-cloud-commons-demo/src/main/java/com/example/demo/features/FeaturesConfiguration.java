package com.example.demo.features;

import org.springframework.cloud.client.actuator.HasFeatures;
import org.springframework.cloud.client.actuator.NamedFeature;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/12/13
 */
public class FeaturesConfiguration {

    @Bean
    public HasFeatures commonsFeatures() {
        return HasFeatures.abstractFeatures(DiscoveryClient.class, LoadBalancerClient.class);
    }

//    @Bean
//    public HasFeatures consulFeatures() {
//        return HasFeatures.namedFeatures(
//                new NamedFeature("Spring Cloud Bus", ConsulBusAutoConfiguration.class),
//                new NamedFeature("Circuit Breaker", HystrixCommandAspect.class));
//    }
//
//    @Bean
//    HasFeatures localFeatures() {
//        return HasFeatures.builder()
//                .abstractFeature(Something.class)
//                .namedFeature(new NamedFeature("Some Other Feature", Someother.class))
//                .abstractFeature(Somethingelse.class)
//                .build();
//    }
}
