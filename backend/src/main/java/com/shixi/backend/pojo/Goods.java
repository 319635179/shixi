package com.shixi.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String id;
    private String name;
    private String tags;
    private double price;
    private String shopid;
    private Integer commentTotal;
    private Date createTime;
    private Date updateTime;
    private boolean isDel;
    private String belongUrl;
    private Integer status;
    private String photoUrl;
}
