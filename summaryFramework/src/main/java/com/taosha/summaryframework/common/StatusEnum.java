package com.taosha.summaryframework.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 5:49 PM
 **/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusEnum {
    //成功
    SUCCESS(true,"yes"),
    //失败
    FAIL(false,"no");

    private boolean status;
    private String type;

}
