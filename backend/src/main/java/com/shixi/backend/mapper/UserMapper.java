package com.shixi.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shixi.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
