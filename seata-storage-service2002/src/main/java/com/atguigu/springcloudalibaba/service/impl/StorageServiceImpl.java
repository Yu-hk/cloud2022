package com.atguigu.springcloudalibaba.service.impl;

import com.atguigu.springcloudalibaba.dao.StorageDao;
import com.atguigu.springcloudalibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lenovo
 */

@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
