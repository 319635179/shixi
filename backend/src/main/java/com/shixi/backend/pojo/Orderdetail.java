package com.shixi.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderdetail {
    private String id;
    private String orderId;
    private String goodsId;
    private String goodsName;
    private Double goodsPrice;
    private String goodsNum;
}
