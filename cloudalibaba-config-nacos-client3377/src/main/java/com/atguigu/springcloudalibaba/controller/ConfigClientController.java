package com.atguigu.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 */

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/nacos/getconfigInfo")
    public String getconfigInfo(){
        return "当前端口为:"+serverPort+",配置信息:"+configInfo;
    }
}
