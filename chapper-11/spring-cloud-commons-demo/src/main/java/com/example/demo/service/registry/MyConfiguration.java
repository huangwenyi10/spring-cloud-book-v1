package com.example.demo.service.registry;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.context.annotation.Configuration;

/**
 * @author ay
 * @since 2020-12-014
 */
@Configuration
@EnableDiscoveryClient(autoRegister=false)
public class MyConfiguration {
    private ServiceRegistry registry;

    public MyConfiguration(ServiceRegistry registry) {
        this.registry = registry;
    }

    // register通过其他的程序调用，例如事件或者自定义的端点
    public void register() {
        Registration registration = constructRegistration();
        this.registry.register(registration);
    }
}