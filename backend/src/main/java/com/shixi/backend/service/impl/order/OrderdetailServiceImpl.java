package com.shixi.backend.service.impl.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixi.backend.mapper.GoodsMapper;
import com.shixi.backend.mapper.OrderdetailMapper;
import com.shixi.backend.pojo.Goods;
import com.shixi.backend.pojo.Orderdetail;
import com.shixi.backend.service.order.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author wzh
 */
@Service
public class OrderdetailServiceImpl implements OrderdetailService {
    @Autowired
    private OrderdetailMapper orderdetailMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Orderdetail> getOrderdetailByOrderId(String orderId) {
        QueryWrapper<Orderdetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("orderId", orderId);
        return orderdetailMapper.selectList(queryWrapper);
    }

    @Override
    public Map<String, String> addOrderdetail(Map<String, String> data) {
        String goodsId = data.get("goodsId");
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", goodsId);
        Goods goods = goodsMapper.selectOne(queryWrapper);
        Map<String, String> map = new HashMap<>();
        if (goods == null){
            map.put("error_message", "货物不存在");
            return map;
        }

        Orderdetail orderdetail = new Orderdetail(UUID.randomUUID().toString(), data.get("orderId"), goodsId, goods.getName(),
                goods.getPrice(), data.get("goodsNum"));
        orderdetailMapper.insert(orderdetail);

        map.put("error_message", "success");
        return map;
    }

    @Override
    public Map<String, String> modifyOrderdetail(Map<String, String> data) {
        return null;
    }

    @Override
    public Map<String, String> removeOrderdetail(Map<String, String> data) {
        return null;
    }
}
