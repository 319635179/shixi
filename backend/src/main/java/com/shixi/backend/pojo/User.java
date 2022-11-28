package com.shixi.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private boolean status;
    private String avatarurl;
    private boolean sex;
    private String country;
    private String province;
    private String city;
    private String mobile;
    private String openId;
    private Date createTime;
    private Date updateTime;
}
