package com.ay.cloud.controller;

import com.ay.cloud.service.OrderService;
import com.ay.cloud.domain.Result;
import com.ay.cloud.domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 描述：订单控制层
 * @author ay
 * @since 2020-09-17
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public Result create(Order order) {
        orderService.create(order);
        return new Result("订单创建成功!", 200);
    }
}
