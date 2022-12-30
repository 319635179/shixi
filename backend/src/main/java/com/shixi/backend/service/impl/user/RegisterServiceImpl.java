package com.shixi.backend.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.UserMapper;
import com.shixi.backend.pojo.User;
import com.shixi.backend.service.pojoservice.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword, Map<String, String> data) {
        Map<String ,String >map = new HashMap<>();
        if(username == null || "".equals(username)){
            map.put("error_message", "用户名不能为空");
            return map;
        }else if(password==null||confirmedPassword==null || "".equals(password) || "".equals(confirmedPassword)){
            map.put("error_message", "密码不能为空");
            return map;
        }

        if(username.length() > 100){
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }

        if(password.length()>100){
            map.put("error_message", "密码长度不能大于100");
            return map;
        }

        if(!password.equals(confirmedPassword)){
            map.put("error_message", "两次输入密码不一致");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()){
            map.put("error_message", "用户名已存在");
            return map;
        }
        String encodedPassword = passwordEncoder.encode(password);
        boolean sex;
        if(data.get("sex") == "男") {
            sex = false;
        } else {
            sex = true;
        }
        User user = new User(UUID.randomUUID().toString(), username, encodedPassword, false, null,
                sex, data.get("country"), data.get("province"), data.get("city"), data.get("mobile"),
                UUID.randomUUID().toString(), new Date(), new Date());
        userMapper.insert(user);

        map.put("error_message", "success");
        return map;
    }
}
