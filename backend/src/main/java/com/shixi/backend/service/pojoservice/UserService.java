package com.shixi.backend.service.pojoservice;

import com.shixi.backend.pojo.User;

import java.util.List;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
public interface UserService {
    public List<User> getAllUser();

    public String addUser(String username, String  password, boolean status, boolean sex,
                          String country, String provience, String city, String mobel);
}
