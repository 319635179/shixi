package com.shixi.backend.service.order;

import com.shixi.backend.pojo.Orders;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Orders> getAllOrder(Integer page, Integer index, String search);

    List<Orders> getOrderByUserId(String userId);

    Map<String, String> addOrder(Map<String, String> data);

    Map<String, String> modifyOrder(Map<String, String> data);

    Map<String, String> deleteOrder(Map<String, String> data);
}
