package com.shixi.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private String id;
    private String shopName;
    private String goodsClass;
    private String provideArea;
    private String liaisonName;
    private String liaisonMoble;
    private String otherConnect;
    private boolean isAudit;
    private boolean isDel;
    private Date createTime;
    private Date updateTime;
}
