package com.atguigu.springcloudalibaba.service.impl;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.service.ConsumerService;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 */

@Component
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public CommonResult<Payment> paymentById(Long id) {
        return new CommonResult<Payment>(404,"服务调用异常------",new Payment(id,"null"));
    }
}
