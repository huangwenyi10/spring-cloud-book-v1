package com.macro.cloud.service;


public interface StockService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
