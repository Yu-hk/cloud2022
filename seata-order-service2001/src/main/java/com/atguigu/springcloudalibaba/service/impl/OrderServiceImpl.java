package com.atguigu.springcloudalibaba.service.impl;

import com.atguigu.springcloudalibaba.dao.OrderDao;
import com.atguigu.springcloudalibaba.domain.Order;
import com.atguigu.springcloudalibaba.service.AccountService;
import com.atguigu.springcloudalibaba.service.OrderService;
import com.atguigu.springcloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lenovo
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "default",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("创建订单开始------------");
        orderDao.create(order);

        log.info("库存开始扣减------------");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("账户开始扣减------------");
        accountService.cost(order.getUserId(),order.getMoney());

        log.info("修改商品状态------------");
        orderDao.update(order.getUserId(),0);

    }
}
