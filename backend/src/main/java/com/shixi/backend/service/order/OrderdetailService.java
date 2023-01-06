package com.shixi.backend.service.order;

import com.shixi.backend.pojo.Orderdetail;

import java.util.List;
import java.util.Map;

public interface OrderdetailService {
    List<Orderdetail> getOrderdetailByOrderId(String orderId);

    Map<String, String> addOrderdetail(Map<String, String> data);

    Map<String, String> modifyOrderdetail(Map<String, String> data);

    Map<String, String> removeOrderdetail(Map<String, String> data);
}
