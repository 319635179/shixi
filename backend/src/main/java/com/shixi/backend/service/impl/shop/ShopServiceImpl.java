package com.shixi.backend.service.impl.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.ShopMapper;
import com.shixi.backend.pojo.Shop;
import com.shixi.backend.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Shop> getAllShop(Integer page, Integer index, String search) {
        if(page==null||index==null){
            page = 1;
            index = 998000;
        }
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDel", "0");
        List<Shop> list = shopMapper.selectList(queryWrapper), result = new ArrayList<>();
        if(search != null){
            for(Shop shop : list){
                if(shop.getShopName().contains(search) || shop.getGoodsClass().contains(search)
                    || shop.getLiaisonName().contains(search) || shop.getProvideArea().contains(search)){
                    result.add(shop);
                }
            }
        }else{
            result = list;
        }
        result = result.subList((page-1)*index, Math.min(result.toArray().length, page * index));
        return result;
    }

    @Override
    public Map<String, String> addShop(Map<String, String> data) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shopName", data.get("shopName"));
        System.out.println(data.get("shopName"));
        Map<String, String> map = new HashMap<>();
        if(shopMapper.selectOne(queryWrapper) != null){
            map.put("error_message","商店名重复");
            return map;
        }else{
            Date date = new Date();
            String name = data.get("shopName");
            String goodsClass = data.get("goodsClass");
            String provideArea = data.get("provideArea");
            String liaisonName = data.get("liaisonName");
            String liaisonMoble = data.get("liaisonMoble");
            if(name == null || "".equals(name)){
                map.put("error_message","商品名不能为空");
                return map;
            }
            if(goodsClass == null || "".equals(goodsClass)){
                map.put("error_message","分类不能为空");
                return map;
            }
            if(provideArea == null || "".equals(provideArea)){
                map.put("error_message","区域不能为空");
                return map;
            }
            if(liaisonName == null || "".equals(liaisonName)){
                map.put("error_message","联系人不能为空");
                return map;
            }
            if(liaisonMoble == null || "".equals(liaisonMoble)){
                map.put("error_message","联系方式不能为空");
                return map;
            }
            Shop shop = new Shop(UUID.randomUUID().toString(), name, goodsClass, provideArea, liaisonName,
                    liaisonMoble, data.get("otherConnect"), true, false, date, date);
            shopMapper.insert(shop);
            map.put("error_message", "success");
        }
        return map;
    }

    @Override
    public Map<String, String> modifyShop(Map<String, String> data) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", data.get("id"));
        Shop shop = shopMapper.selectOne(queryWrapper);
        Map<String, String> map = new HashMap<>();
        if(shop == null){
            map.put("error_message", "查询不到此商店");
            return map;
        }
        shop.setShopName(data.get("shopName"));
        shop.setGoodsClass(data.get("goodsClass"));
        shop.setProvideArea(data.get("provideArea"));
        shop.setLiaisonName(data.get("liaisonName"));
        shop.setLiaisonMoble(data.get("liaisonMoble"));
        shop.setOtherConnect(data.get("otherConnect"));
        shop.setUpdateTime(new Date());
        shopMapper.updateById(shop);
        map.put("error_message", "success");
        return map;
    }

    @Override
    public Map<String, String> deleteShop(String id) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Shop shop = shopMapper.selectOne(queryWrapper);
        Map<String, String> map = new HashMap<>();
        if(shop == null){
            map.put("error_message", "不存在此商店");
            return map;
        }
        shop.setDel(true);
        shopMapper.updateById(shop);
        map.put("error_message", "success");
        return map;
    }

    @Override
    public Shop getShopById(String id) {
        QueryWrapper<Shop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return shopMapper.selectOne(queryWrapper);
    }
}
