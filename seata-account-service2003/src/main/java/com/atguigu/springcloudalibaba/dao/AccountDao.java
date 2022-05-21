package com.atguigu.springcloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Lenovo
 */

@Mapper
public interface AccountDao {

    void cost(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
