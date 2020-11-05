package com.ay.cloud.service;


import com.ay.cloud.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
