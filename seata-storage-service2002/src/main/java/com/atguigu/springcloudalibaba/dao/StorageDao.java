package com.atguigu.springcloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lenovo
 */

@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId,@Param("count") Integer count);

}
