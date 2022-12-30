package com.shixi.backend.controller.goods;

import com.shixi.backend.formate.Result;
import com.shixi.backend.pojo.Goods;
import com.shixi.backend.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/query/goods")
    public Result getAllGoods(Integer page,Integer index,String search){
        return new Result(200, "", 1, goodsService.getAllGoods(page, index, search));
    }

    @GetMapping("/query/goods/byId")
    public Goods getGoodsById(String goodsId){
        return goodsService.getGoodsById(goodsId);
    }

    @PostMapping("/add/goods")
    public Map<String, String> addGoods(@RequestParam Map<String, String> data){
        return goodsService.addGoods(data);
    }

    @PostMapping("/modify/goods")
    public Map<String, String> modifyGoods(@RequestParam Map<String, String> data){
        return goodsService.modifyGoods(data);
    }

    @PostMapping("/delete/goods")
    public Map<String, String> deleteGoods(String id){
        return goodsService.deleteGoods(id);
    }
}
