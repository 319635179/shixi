package com.shixi.backend.service.shop;

import com.shixi.backend.pojo.Shop;

import java.util.List;
import java.util.Map;

public interface ShopService {
    public List<Shop> getAllShop(Integer page, Integer index, String search);

    public Map<String, String> addShop(Map<String, String> data);

    public Map<String, String> modifyShop(Map<String, String> data);

    public Map<String, String> deleteShop(String id);

    public Shop getShopById(String id);
}
