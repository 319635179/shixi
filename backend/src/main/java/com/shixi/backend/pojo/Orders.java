package com.shixi.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private String id;
    private String orderId;
    private Double amountPayable;
    private Double actuallyPayable;
    private Integer status;
    private Date orderTime;
    private String userId;
    private String userName;
    private boolean isSite;
    private String address;
    private String siteId;
    private String siteName;
    private String siteAddress;
    private String note;
    private String receiverName;
    private String receiverTel;
    private boolean isDel;
    private Date createTime;
    private Date updateTime;
}
