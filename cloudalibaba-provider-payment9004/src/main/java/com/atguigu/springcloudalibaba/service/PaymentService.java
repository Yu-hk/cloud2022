package com.atguigu.springcloudalibaba.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lenovo
 */

@Mapper
public interface PaymentService {

    Payment getPaymentById(@Param("id") Long id);
}
