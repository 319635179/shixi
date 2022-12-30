package com.shixi.backend.service.impl.goods;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.GoodsMapper;
import com.shixi.backend.mapper.ShopMapper;
import com.shixi.backend.pojo.Goods;
import com.shixi.backend.pojo.Shop;
import com.shixi.backend.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Administrator
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public List<Goods> getAllGoods(Integer page,Integer index,String search) {
        if(page==null||index==null){
            page = 1;
            index = 998000;
        }
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDel", "0");
        List<Goods> list = goodsMapper.selectList(queryWrapper), result = new ArrayList<>();
        if(search != null){
            for(Goods goods : list){
                if(goods.getName().contains(search) || goods.getTags().contains(search)){
                    result.add(goods);
                }
            }
        }else{
            result = list;
        }
        result = result.subList((page-1)*index, Math.min(result.toArray().length, page * index));
        return result;
    }

    @Override
    public Map<String, String> addGoods(Map<String, String> data) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", data.get("name"));
        Map<String, String> map = new HashMap<>();
        if(goodsMapper.selectOne(queryWrapper) != null){
            map.put("error_message","商品名重复");
            return map;
        }else{
            Date date = new Date();
            String name = data.get("name");
            String price = data.get("price");
            if(name == null || "".equals(name)){
                map.put("error_message","商品名不能为空");
                return map;
            }
            if(price == null || "".equals(price)){
                map.put("error_message","价格不能为空");
                return map;
            }
            if(shopMapper.selectOne(new QueryWrapper<Shop>().eq("shopName", data.get("shopName")))==null){
                map.put("error_message","商店名错误");
                return map;
            }
            Goods goods = new Goods(UUID.randomUUID().toString(), name, data.get("tag"),
                    Double.parseDouble(price), shopMapper.selectOne(new QueryWrapper<Shop>().eq("shopName", data.get("shopName"))).getId(),
                    0, date, date, false, "", 2, data.get("url"));
            goodsMapper.insert(goods);
            map.put("error_message", "success");
        }
        return map;
    }

    @Override
    public Map<String, String> modifyGoods(Map<String, String> data) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", data.get("id"));
        Goods goods = goodsMapper.selectOne(queryWrapper);
        Map<String, String> map = new HashMap<>();
        if(goods == null){
            map.put("error_message", "查询不到此商品");
            return map;
        }
        if(shopMapper.selectOne(new QueryWrapper<Shop>().eq("shopName", data.get("shopid")))==null){
            map.put("error_message","商店名错误");
            return map;
        }
        goods.setName(data.get("Goodsname"));
        goods.setTags(data.get("tag"));
        goods.setPrice(Double.parseDouble(data.get("price")));
        goods.setStatus(Integer.valueOf(data.get("status")));
        goods.setPhotoUrl(data.get("url"));
        goods.setShopid(shopMapper.selectOne(new QueryWrapper<Shop>().eq("shopName", data.get("shopid"))).getId());
        goods.setUpdateTime(new Date());
        goodsMapper.updateById(goods);
        map.put("error_message", "success");
        return map;
    }

    @Override
    public Map<String, String> deleteGoods(String id) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Goods goods = goodsMapper.selectOne(queryWrapper);
        Map<String, String> map = new HashMap<>();
        if(goods == null){
            map.put("error_message", "不存在此商品");
            return map;
        }
        goods.setDel(true);
        goodsMapper.updateById(goods);
        map.put("error_message", "success");
        return map;
    }

    @Override
    public Goods getGoodsById(String goodsId) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", goodsId);
        return goodsMapper.selectOne(queryWrapper);
    }
}
