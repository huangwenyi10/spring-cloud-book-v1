package com.example.demo.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon配置类，不能被@ComponentScan扫描到
 *
 * @author ay
 * @since 2020-07-14
 */
@Configuration
public class RibbonConfiguration {

//    @Bean
//    public IRule ribbonRule(){
//        //ribbon默认是使用的是zoneAvoidanceRule规则，这里修改为随机方式
//        return new RandomRule();
//    }

    //    @Bean
//    public IRule ribbonRule(){
//        //ribbon默认是使用的是zoneAvoidanceRule规则，这里修改为随机方式
//        return new NacosWeightedRule();
//    }
    @Bean
    public IRule ribbonRule() {
        //ribbon默认是使用的是zoneAvoidanceRule规则，这里修改为随机方式
        return new MyRule();
    }
}
//https://blog.csdn.net/qq_31489805/article/details/80341200 (springcloud之ribbon自定义负载均衡规则)
//https://www.cnblogs.com/softidea/p/11000930.html (ribbon自带负载均衡策略)