package com.shixi.backend.controller.user;

import com.shixi.backend.formate.Result;
import com.shixi.backend.service.pojoservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result getAllUser(){
        return new Result(200,"",1, userService.getAllUser());
    }
}
