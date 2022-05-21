package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 */

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/test/a")
    public String testA() throws InterruptedException {
        Thread.sleep(3000);
        return "testA";
    }

    @GetMapping("/test/b")
    public String testB() {
        log.info("当前调用线程:"+Thread.currentThread().getName());
        return "testB";
    }

    @GetMapping("/test/c")
    public String testC() {
        log.info("testC-------RT");
        return "testC";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testHotKey------";
    }

    public String deal_testHotKey(){
        return "deal_testHotKey-----";
    }

}
