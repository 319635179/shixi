package com.shixi.backend.service.impl.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.GoodsMapper;
import com.shixi.backend.mapper.OrdersMapper;
import com.shixi.backend.pojo.Goods;
import com.shixi.backend.pojo.Orders;
import com.shixi.backend.service.order.OrderService;
import com.shixi.backend.service.order.OrderdetailService;
import com.shixi.backend.service.shoppingbag.ShoppingbagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author wzh
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderdetailService orderdetailService;
    @Autowired
    private ShoppingbagService shoppingbagService;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Orders> getAllOrder(Integer page, Integer index, String search) {
        if(page==null||index==null){
            page = 1;
            index = 998000;
        }
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDel", "0");
        List<Orders> list = ordersMapper.selectList(queryWrapper), result = new ArrayList<>();
        if(search != null){
            for(Orders orders : list){
                if(orders.getReceiverName().contains(search) || orders.getAddress().contains(search)){
                    result.add(orders);
                }
            }
        }else{
            result = list;
        }
        result = result.subList((page-1)*index, Math.min(result.toArray().length, page * index));
        return result;
    }

    @Override
    public List<Orders> getOrderByUserId(String userId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId).eq("isDel", "0");
        return ordersMapper.selectList(queryWrapper);
    }

    @Override
    public Map<String, String> addOrder(Map<String, String> data) {
        Map<String, String> map = new HashMap<>();
        if(data.get("amountPayable") == null || data.get("actuallyPayable") == null
            || Objects.equals(data.get("amountPayable"), "") || Objects.equals(data.get("actuallyPayable"), "")){
            map.put("error_message", "价格获取失败");
            return map;
        }

        Double amountPayable = Double.valueOf(data.get("amountPayable"));
        Double actuallyPayable = Double.valueOf(data.get("actuallyPayable"));
        String userId = data.get("userId");
        String userName = data.get("userName");
        String receiverName = data.get("receiverName");
        String receiverTel = data.get("receiverTel");

        if(userId == null || userName == null || "".equals(userId) || "".equals(userName)){
            map.put("error_message", "用户错误");
            return  map;
        }
        if(receiverTel == null || receiverName == null || "".equals(receiverName) || "".equals(receiverTel)){
            map.put("error_message", "收货人信息错误");
        }
        if(data.get("isSite") == null || "".equals(data.get("isSite"))){
            map.put("error_message", "地址信息错误");
            return map;
        }
        boolean isSite = Objects.equals(data.get("isSite"), "1");

        String id = UUID.randomUUID().toString();
        Date date = new Date();
        Orders orders = new Orders();
        orders.setId(id);
        orders.setOrderId(UUID.randomUUID().toString());
        orders.setAmountPayable(amountPayable);
        orders.setActuallyPayable(actuallyPayable);
        orders.setStatus(1);
        orders.setOrderTime(date);
        orders.setUserId(userId);
        orders.setUserName(userName);
        if(isSite){
            orders.setSiteId(data.get("siteId"));
            orders.setSiteName(data.get("siteName"));
            orders.setSiteAddress(data.get("siteAddress"));
        }else{
            orders.setAddress(data.get("address"));
        }
        orders.setNote(data.get("note"));
        orders.setReceiverName(receiverName);
        orders.setReceiverTel(receiverTel);
        orders.setCreateTime(date);
        orders.setUpdateTime(date);

        String[] goods = data.get("goodsIds").split(",");

        for(String goodsId : goods){
            QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", goodsId);
            if (goodsMapper.selectOne(queryWrapper) == null){
                map.put("error_message", "货物信息错误");
                return map;
            }
        }

        for(String goodsId : goods){
            Map<String, String> goodsData = new HashMap<>();
            goodsData.put("goodsId", goodsId);
            goodsData.put("orderId", orders.getOrderId());
            goodsData.put("goodsNum", shoppingbagService.getGoodsNumByUserIdAndGoodsId(orders.getUserId(), goodsId).toString());
            shoppingbagService.deleteShoppingbag(shoppingbagService.getShoppingbagIdByUserIdAndGoodsId(userId, goodsId));
            orderdetailService.addOrderdetail(goodsData);
        }

        ordersMapper.insert(orders);

        map.put("error_message", "success");
        map.put("order_id", id);
        return map;
    }

    @Override
    public Orders getOrderById(String id) {
        Orders orders = ordersMapper.selectById(id);
        return orders;
    }

    @Override
    public Map<String, String> modifyOrder(Map<String, String> data) {
        return null;
    }

    @Override
    public Map<String, String> deleteOrder(Map<String, String> data) {
        return null;
    }
}
