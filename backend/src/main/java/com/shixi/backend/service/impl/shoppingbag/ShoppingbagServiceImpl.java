package com.shixi.backend.service.impl.shoppingbag;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.GoodsMapper;
import com.shixi.backend.mapper.ShoppingbagMapper;
import com.shixi.backend.mapper.UserMapper;
import com.shixi.backend.pojo.Shoppingbag;
import com.shixi.backend.service.shoppingbag.ShoppingbagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShoppingbagServiceImpl implements ShoppingbagService {

    @Autowired
    private ShoppingbagMapper shoppingbagMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Shoppingbag> getShoppingbagListByUserId(String userId) {
        QueryWrapper<Shoppingbag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        return shoppingbagMapper.selectList(queryWrapper);
    }

    @Override
    public Map<String, String> addShoppingbag(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        String userId = data.get("userId");
        String goodsId = data.get("goodsId");
        if(userId == null || goodsId == null || data.get("goodsNum") == null){
            map.put("error_message", "用户或商品信息错误");
            return map;
        }
        if(userMapper.selectById(userId) == null || goodsMapper.selectById(goodsId) == null){
            map.put("error_message", "用户或商品不存在");
            return map;
        }
        Integer goodsNum = Integer.valueOf(data.get("goodsNum"));
        Date date = new Date();
        Shoppingbag shoppingbag = new Shoppingbag(UUID.randomUUID().toString(), userId, goodsId, goodsNum,
                goodsMapper.selectById(goodsId).getShopid(), date, date);
        shoppingbagMapper.insert(shoppingbag);
        map.put("error_message", "success");
        return map;
    }

    @Override
    public Map<String, String> modifyShoppingbagGoodsNum(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        String id = data.get("id");
        Shoppingbag shoppingbag = shoppingbagMapper.selectById(id);
        if(shoppingbag == null){
            map.put("error_message", "购物车信息不存在");
            return map;
        }
        if("changeNum".equals(data.get("type"))){
            shoppingbag.setGoodsNum(Integer.valueOf(data.get("goodsNum")));
            shoppingbag.setUpdateTime(new Date());
            shoppingbagMapper.updateById(shoppingbag);
            map.put("error_message", "success");
            return map;
        }
        map.put("error_message", "error");
        return map;
    }

    @Override
    public Map<String, String> deleteShoppingbag(String id) {
        Map<String, String> map = new HashMap<>();
        Shoppingbag shoppingbag = shoppingbagMapper.selectById(id);
        if(shoppingbag == null){
            map.put("error_message", "购物车信息不存在");
            return map;
        }
        shoppingbagMapper.deleteById(id);
        map.put("error_message", "success");
        return map;
    }
}
