package com.atguigu.springcloudalibaba.controller;

import com.atguigu.springcloudalibaba.domain.CommonResult;
import com.atguigu.springcloudalibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 */

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"库存扣减成功!!");
    }
}
