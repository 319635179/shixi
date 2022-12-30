package com.shixi.backend.controller.user;

import com.shixi.backend.service.pojoservice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/user/login")
    public Map<String ,String> getToken(@RequestParam Map<String ,String >map){
        String username = map.get("username");
        String password = map.get("password");
        return loginService.getToken(username,password);
    }
}
