package com.shixi.backend.service.pojoservice;

import com.shixi.backend.pojo.User;

import java.util.List;
import java.util.Map;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
public interface UserService {
    public List<User> getAllUser();

    public String addUser(String username, String  password, boolean status, boolean sex,
                          String country, String province, String city, String mobile);

    public String modifyUser(String id, String username, boolean status, boolean sex, String country,
                             String province, String city, String mobile);

    public String modifyUserPassword(String id, String password);

    public Map<String, String> deleteUser(String id);
}
