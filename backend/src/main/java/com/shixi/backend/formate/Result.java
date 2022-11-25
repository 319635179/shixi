package com.shixi.backend.formate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*
* @author: 汪子涵
* @date: 2022/11/25
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;
}
