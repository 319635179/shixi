package com.shixi.backend.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.UserMapper;
import com.shixi.backend.pojo.User;
import com.shixi.backend.service.pojoservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *
     * @return 获取全部用户
     */
    @Override
    public List<User> getAllUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public String addUser(String username, String  password, boolean status, boolean sex,
                          String country, String provience, String city, String mobile) {
        User user = new User(UUID.randomUUID().toString(), username, passwordEncoder.encode(password), status,
                null, sex, country, provience, city, mobile,
                UUID.randomUUID().toString(), new Date(), new Date());
        userMapper.insert(user);
        return "success";
    }

    @Override
    public String modifyUser(String id, String username, boolean status, boolean sex, String country,
                             String province, String city, String mobile) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        User user = userMapper.selectOne(queryWrapper);
        user.setUsername(username);
        user.setStatus(status);
        user.setSex(sex);
        user.setCountry(country);
        user.setProvince(province);
        user.setCity(city);
        user.setMobile(mobile);
        userMapper.updateById(user);
        return "success";
    }

    @Override
    public String modifyUserPassword(String id, String password) {
        return null;
    }

    @Override
    public Map<String, String> deleteUser(String id) {
        System.out.println(id);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        User user = userMapper.selectOne(queryWrapper);
        Map<String, String> map = new HashMap<>();
        if(user == null){
            map.put("error_message", "不存在此用户");
            return map;
        }
        userMapper.deleteById(user);
        map.put("error_message", "success");
        return map;
    }
}
