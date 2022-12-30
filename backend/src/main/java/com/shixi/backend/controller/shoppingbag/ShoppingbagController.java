package com.shixi.backend.controller.shoppingbag;

import com.shixi.backend.pojo.Shoppingbag;
import com.shixi.backend.service.shoppingbag.ShoppingbagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ShoppingbagController {
    @Autowired
    private ShoppingbagService shoppingbagService;

    @GetMapping("/query/shoppingbag")
    public List<Shoppingbag> getShoppingbag(String userId){
        return shoppingbagService.getShoppingbagListByUserId(userId);
    }

    @PostMapping("/add/shoppingbag")
    public Map<String, String> addShoppingbag(@RequestParam Map<String, String> data){
        return shoppingbagService.addShoppingbag(data);
    }

    @PostMapping("/update/shoppingbag")
    public Map<String, String> modifyShoppingbag(@RequestParam Map<String, String> data){
        return shoppingbagService.modifyShoppingbagGoodsNum(data);
    }

    @PostMapping("/delete/shoppingbag")
    public Map<String, String> deleteShoppingbag(String id){
        return shoppingbagService.deleteShoppingbag(id);
    }
}
