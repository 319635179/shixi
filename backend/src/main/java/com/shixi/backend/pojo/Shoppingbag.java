package com.shixi.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shoppingbag {
    private String id;
    private String userId;
    private String goodsId;
    private Integer goodsNum;
    private String shopId;
    private Date createTime;
    private Date updateTime;
}
