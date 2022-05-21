package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOK(Integer id) {
        return "-------PaymentFallbackService paymentInfoOK";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-------PaymentFallbackService paymentInfoTimeout";
    }
}
