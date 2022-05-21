package com.atguigu.springcloudalibaba.service.impl;

import com.atguigu.springcloudalibaba.dao.AccountDao;
import com.atguigu.springcloudalibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Lenovo
 */

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;

    @Override
    public void cost(Long userId, BigDecimal money) {
        accountDao.cost(userId, money);
    }
}
