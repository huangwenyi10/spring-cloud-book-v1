package com.example.demo.config;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 负载规则：始终返回第一个服务
 * @author ay
 * @since 2020-07-14
 */
public class MyRule extends AbstractLoadBalancerRule {

    private ILoadBalancer lb;
    public MyRule() {}

    @Override
    public Server choose(Object o) {
        ILoadBalancer lb = getLoadBalancer();
        // 获取所有的服务
        List<Server> servers = lb.getAllServers();
//        for (Server s : servers){
//            System.out.println("服务器的端口号："+ s.getHostPort());
//        }
        return servers.get(0); // 始终返回第一个服务
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}