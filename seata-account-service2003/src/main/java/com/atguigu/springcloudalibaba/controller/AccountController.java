package com.atguigu.springcloudalibaba.controller;

import com.atguigu.springcloudalibaba.domain.CommonResult;
import com.atguigu.springcloudalibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Lenovo
 */

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/cost")
    public CommonResult cost(Long userId, BigDecimal money){
        accountService.cost(userId, money);
        return new CommonResult(200,"账户扣减成功!!");
    }
}
