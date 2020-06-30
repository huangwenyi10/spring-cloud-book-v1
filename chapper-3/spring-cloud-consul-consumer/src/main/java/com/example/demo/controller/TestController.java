package com.example.demo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ay
 * @since 2020-06-27
 */
@RestController
public class TestController {
    @Resource
    private LoadBalancerClient loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;
    //获取所有服务
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("consul-producer");
    }
     //从所有服务中选择一个服务（轮询）
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancer.choose("consul-producer").getUri().toString();
    }
    //服务调用
    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("consul-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        String callServiceResult =
                new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/test/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }
}
