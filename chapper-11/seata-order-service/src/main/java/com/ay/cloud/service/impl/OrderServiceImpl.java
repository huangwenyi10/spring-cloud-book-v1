package com.ay.cloud.service.impl;

import com.ay.cloud.dao.OrderDao;
import com.ay.cloud.domain.Order;
import com.ay.cloud.service.AccountService;
import com.ay.cloud.service.OrderService;
import com.ay.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单业务实现类
 * @author ay
 * @since 2020-09-27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 总体流程为：创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        System.out.println("--->>>下单开始");
        //本应用创建订单
        orderDao.create(order);

        //远程调用库存服务扣减库存
        System.out.println("------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        System.out.println("------->order-service中扣减库存结束");

        //远程调用账户服务扣减余额
        System.out.println("------->order-service中扣减余额开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        System.out.println("------->order-service中扣减余额结束");

        //修改订单状态为已完成
        System.out.println("------->order-service中修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        System.out.println("------->order-service中修改订单状态结束");

        System.out.println("------->下单结束");
    }
}
