package com.shixi.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shixi.backend.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
