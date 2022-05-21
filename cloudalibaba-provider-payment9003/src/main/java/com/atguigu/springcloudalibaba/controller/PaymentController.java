package com.atguigu.springcloudalibaba.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lenovo
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> paymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> result = new CommonResult<>(200,"访问端口:"+serverPort,payment);
        return result;
    }
}
