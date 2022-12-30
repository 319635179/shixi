package com.shixi.backend.service.goods;

import com.shixi.backend.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> getAllGoods(Integer page,Integer index,String search);

    Map<String, String> addGoods(Map<String, String> data);

    Map<String, String> modifyGoods(Map<String, String> data);

    Map<String, String> deleteGoods(String id);

    Goods getGoodsById(String goodsId);
}
