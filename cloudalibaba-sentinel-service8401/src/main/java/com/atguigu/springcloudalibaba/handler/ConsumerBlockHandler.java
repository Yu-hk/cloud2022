package com.atguigu.springcloudalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author Lenovo
 */
public class ConsumerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult<>(404,"客户自定义异常1------");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult<>(404,"客户自定义异常2------");
    }

}
