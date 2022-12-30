package com.shixi.backend.controller.goods;

import com.shixi.backend.service.goods.GoodsPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.Map;

@RestController
public class GoodsPhotoController {
    @Autowired
    GoodsPhotoService goodsPhotoService;
    @PostMapping(value = "/add/photo")
    public Map<String, String> addPhoto(MultipartFile multipartFile){
//        System.out.println(map);
        System.out.println(new Date());
        System.out.println(multipartFile);
        return goodsPhotoService.addPhoto(multipartFile);
    }
}
