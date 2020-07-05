package com.example.demo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class InvokeController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/consumer/invoke")
    public String invoke(){
        ServiceInstance serviceInstance =
                loadBalancer.choose("service-provider");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        //使用 RestTemplate 进行远程调用
        String callServiceResult = restTemplate.getForObject("http://"+ serviceInstance.getServiceId()
                        .toString() + "/provider/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }
}
