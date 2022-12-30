package com.shixi.backend.controller.user;

import com.shixi.backend.service.pojoservice.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/user/getInfo")
    public Map<String ,String > getInfo(){
        return infoService.getInfo();
    }
}
