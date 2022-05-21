package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Lenovo
 */

@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Resource
    private ConsumerService consumerService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "handlerBlock",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult<Payment> result = restTemplate.getForObject(url+"/payment/"+id, CommonResult.class,id);
        if (id == 10){
            throw new IllegalArgumentException("非法参数异常-----------");
        } else if (result.getData() == null) {
            throw new NullPointerException("未查到相关数据-----------");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        CommonResult<Payment> commonResult = new CommonResult<Payment>(404,"程序异常,请稍后重试----"+e.getMessage(),payment);
        return commonResult;
    }

    public CommonResult<Payment> handlerBlock(@PathVariable("id") Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        CommonResult<Payment> commonResult = new CommonResult<Payment>(403,"系统出错,请稍后重试----"+e.getMessage(),payment);
        return commonResult;
    }

    @GetMapping("/payment/openfeign/{id}")
    public CommonResult<Payment> paymentOpenfeign(@PathVariable("id") Long id){
        return consumerService.paymentById(id);
    }

}
