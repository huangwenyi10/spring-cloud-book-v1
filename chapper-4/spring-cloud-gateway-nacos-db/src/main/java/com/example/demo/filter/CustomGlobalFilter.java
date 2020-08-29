package com.example.demo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 描述：
 *
 * @author ay
 * @since 2020-04-28
 */

public class CustomGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("global filter!!!");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        /**
         * 参考：https://chanjarster.github.io/post/spring-cloud-gateway-filters-ordering/
         * 值越大，优先级越低
         */
        return -1;
    }
}

