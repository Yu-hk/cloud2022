package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloudalibaba.handler.ConsumerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 */

@RestController
public class RateLimitController {

    @GetMapping("/byResourse")
    @SentinelResource(value = "byResourse",blockHandler = "handlerException")
    public CommonResult byResourse(){
        return new CommonResult<>(200,"按资源名称限流测试OK---",new Payment(2022L,"serialno001"));
    }

    public CommonResult handlerException(BlockException exception){
        return new CommonResult(404, exception.getClass().getCanonicalName()+"服务不可用---");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",
            blockHandlerClass = ConsumerBlockHandler.class,
            blockHandler = "handlerException1")
    public CommonResult byUrl(){
        return new CommonResult<>(200,"按Url限流测试OK---",new Payment(2022L,"serialno002"));
    }

    @GetMapping("/ConsumerBlockHandler")
    @SentinelResource(value = "ConsumerBlockHandler",
            blockHandlerClass = ConsumerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult ConsumerBlockHandler(){
        return new CommonResult<>(200,"ConsumerBlockHandler测试OK---",new Payment(2022L,"serialno003"));
    }

}
