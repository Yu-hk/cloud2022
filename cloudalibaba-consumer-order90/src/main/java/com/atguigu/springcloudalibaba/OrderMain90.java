package com.atguigu.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Lenovo
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain90.class);
    }
}
