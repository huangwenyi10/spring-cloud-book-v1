package com.ay.cloud.service;


public interface StockService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
