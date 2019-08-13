package com.taosha.summaryframework.customException.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ErrorMsgEnum {

    //系统错误
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),

    PARAMETER_VALID_NOT_PASS("PARAMETER_VALID_NOT_PASS", "参数校验不通过"),
    ;

    private String code;
    private String msg;
}
