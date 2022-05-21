package com.atguigu.springcloudalibaba.service;

import com.atguigu.springcloudalibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Lenovo
 */

@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/cost")
    CommonResult cost(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
