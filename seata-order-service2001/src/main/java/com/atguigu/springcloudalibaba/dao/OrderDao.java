package com.atguigu.springcloudalibaba.dao;

import com.atguigu.springcloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lenovo
 */

@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId,@Param("status") Integer status);

}
