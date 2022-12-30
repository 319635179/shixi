package com.shixi.backend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.formate.Result;
import com.shixi.backend.pojo.User;
import com.shixi.backend.service.pojoservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    /**
     *
     * @return a list of all user
     */
    @GetMapping("/query/user")
    public Result getAllUser(Integer page,Integer index,String search){
        if(page==null||index==null){
            page = 1;
            index = 998000;
        }
        System.out.println(page + ' ' + index + ' ' + search);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        List<User> list = userService.getAllUser(), result =new ArrayList<>();
        if(search!=null){
            for(User u : list){
                if(u.getUsername().contains(search) || u.getCountry().contains(search) || u.getProvince().contains(search) ||
                        u.getCity().contains(search) || u.getMobile().contains(search)){
                    result.add(u);
                }
            }
        }else{
            result = list;
        }
        result = result.subList((page-1)*index, Math.min(result.toArray().length, page * index));
        return new Result(200,"",1, result);
    }

    @PostMapping("/add/user")
    public String addUser(String username, String  password, boolean status, boolean sex,
                          String country, String province, String city, String mobel){
        userService.addUser(username, password, status, sex, country, province, city, mobel);
        return "success";
    }

    @PostMapping("/update/user")
    public String modifyUser(String id, String username, boolean status, boolean sex, String country,
                             String province, String city, String mobile){
        userService.modifyUser(id, username, status, sex, country, province, city, mobile);
        return "success";
    }

    @PostMapping("/delete/user")
    public Map<String, String> deleteUser(String id){
        return userService.deleteUser(id);
    }
}
