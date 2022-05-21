package com.atguigu.springcloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lenovo
 */

@Configuration
@MapperScan({"com.atguigu.springcloudalibaba.dao"})
public class MyBatisConfig {

}
