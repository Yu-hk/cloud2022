package com.atguigu.springcloudalibaba.controller;



import com.atguigu.springcloudalibaba.domain.CommonResult;
import com.atguigu.springcloudalibaba.domain.Order;
import com.atguigu.springcloudalibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lenovo
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult crete(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功!!");
    }
}
