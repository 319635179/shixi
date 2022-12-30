package com.shixi.backend.service.shoppingbag;

import com.shixi.backend.pojo.Shoppingbag;

import java.util.List;
import java.util.Map;

public interface ShoppingbagService {
    public List<Shoppingbag> getShoppingbagListByUserId(String userId);

    public Map<String, String> addShoppingbag(Map<String, String> data);

    public Map<String, String> modifyShoppingbagGoodsNum(Map<String, String> data);

    public Map<String, String> deleteShoppingbag(String id);
}
