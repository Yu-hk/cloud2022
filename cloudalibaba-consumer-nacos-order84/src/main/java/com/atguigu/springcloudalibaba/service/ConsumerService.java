package com.atguigu.springcloudalibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.service.impl.ConsumerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Lenovo
 */

@FeignClient(value = "nacos-payment-provider",fallback = ConsumerServiceImpl.class)
public interface ConsumerService {

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> paymentById(@PathVariable("id") Long id);
}
