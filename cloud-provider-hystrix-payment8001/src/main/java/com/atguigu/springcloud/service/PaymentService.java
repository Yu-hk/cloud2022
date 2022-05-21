package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 */

@Service
public class PaymentService {

    public String paymentInfoOK(Integer id){
        return "线程池:"+Thread.currentThread().getName() + "paymentInfoOK,id:"+id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfoTimeout(Integer id){
        int time = 3000;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName() + "paymentInfoTimeout,id:"+id+"耗时"+time+"秒钟";
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池:"+Thread.currentThread().getName() + "paymentInfoTimeoutHandler,id:"+id+"服务运行超时,请稍后再试";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("--------id不能为负数!!");
        }
        String serialNumer = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功!!流水号:"+serialNumer;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负,请稍后重试!!";
    }
}
