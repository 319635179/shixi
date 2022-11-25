package com.shixi.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.UserMapper;
import com.shixi.backend.pojo.User;
import com.shixi.backend.service.pojoservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @return 获取全部用户
     */
    @Override
    public List<User> getAllUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        List<User> list = userMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public String addUser(String username, String password) {
        User user = new User(UUID.randomUUID().toString(), username,password,
                null, 0, "中国", "河南", "郑州", "13333333333",
                UUID.randomUUID().toString(), new Date(), new Date());
        userMapper.insert(user);
        return "success";
    }
}
