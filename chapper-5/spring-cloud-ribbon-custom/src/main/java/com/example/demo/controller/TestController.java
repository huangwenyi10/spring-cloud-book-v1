package com.example.demo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/getUserName")
    public String getUserName(){
        for(int i=0; i< 20; i++){
            ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
            //打印当前选择的是哪个节点
            System.out.println(serviceInstance.getServiceId()+serviceInstance.getHost()+ "：" +serviceInstance.getPort());
        }
        return "hello, ay";
    }
}
