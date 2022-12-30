package com.shixi.backend.controller.shop;

import com.shixi.backend.formate.Result;
import com.shixi.backend.pojo.Shop;
import com.shixi.backend.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/query/shop")
    public Result getAllShop(Integer page,Integer index,String search){
        return new Result(200, "", 1, shopService.getAllShop(page, index, search));
    }

    @GetMapping("/query/shop/byid")
    public Shop getShopById(String id){
        return shopService.getShopById(id);
    }

    @PostMapping("/add/shop")
    public Map<String, String> addShop(@RequestParam Map<String, String> data){
        return shopService.addShop(data);
    }

    @PostMapping("/modify/shop")
    public Map<String, String> modifyShop(@RequestParam Map<String, String> data){
        return shopService.modifyShop(data);
    }

    @PostMapping("/delete/shop")
    public Map<String, String> deleteShop(String id){
        return shopService.deleteShop(id);
    }
}
