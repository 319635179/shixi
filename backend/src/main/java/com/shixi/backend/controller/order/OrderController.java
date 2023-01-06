package com.shixi.backend.controller.order;

import com.shixi.backend.pojo.Orders;
import com.shixi.backend.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/query/order")
    public List<Orders> getAllOrder(Integer page, Integer index, String search){
        return orderService.getAllOrder(page, index, search);
    }

    @GetMapping("/query/order/user")
    public List<Orders> getOrderByUserId(String userId){
        return orderService.getOrderByUserId(userId);
    }

    @GetMapping("/query/order/id")
    public Orders getOrderById(String id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/add/order")
    public Map<String, String> addOrder(@RequestParam Map<String, String> data){
        return orderService.addOrder(data);
    }
}
