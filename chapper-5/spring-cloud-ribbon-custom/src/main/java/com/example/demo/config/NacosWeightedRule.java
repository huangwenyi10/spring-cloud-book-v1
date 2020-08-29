package com.example.demo.config;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 规则：权重负载均衡
 *
 * @author ay
 * @since 2020-07-14
 */
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties discoveryProperties;

    /**
     * 读取配置文件并初始化（一般不重写）
     *
     * @param iClientConfig
     */
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    /**
     * 权重负载均衡返回的微服务实例
     *
     * @param o
     * @return
     */
    @Override
    public Server choose(Object o) {

        try {
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //想要请求的微服务的名称
            String name = loadBalancer.getName();
            //拿到服务发现的相关api
            NamingService namingService = discoveryProperties.namingServiceInstance();
            //nacos client 自动通过基于权重的负载均衡算法,给我们选择一个实例
            Instance instance = namingService.selectOneHealthyInstance(name);
            return new NacosServer(instance);
        } catch (NacosException e) {
            return null;
        }
    }
}