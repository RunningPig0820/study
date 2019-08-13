package com.taosha.summaryframework.commonResult.utils;

import com.taosha.summaryframework.common.StatusEnum;
import com.taosha.summaryframework.commonResult.bean.CommonResult;
import com.taosha.summaryframework.commonResult.enums.ErrorMsgEnum;

import java.util.Arrays;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 6:04 PM
 **/
public class ResultUtils {

    public static CommonResult buildSuccess(Object object) {
        return CommonResult.builder()
                .success(StatusEnum.SUCCESS.isStatus())
                .code(ErrorMsgEnum.SUCCESS.getCode())
                .msg(ErrorMsgEnum.SUCCESS.getMsg())
                .data(object)
                .build();
    }

    public static CommonResult buildFail(ErrorMsgEnum errorMsgEnum) {
        return CommonResult.builder()
                .success(StatusEnum.FAIL.isStatus())
                .code(errorMsgEnum.getCode())
                .msg(errorMsgEnum.getMsg())
                .build();
    }

    public static CommonResult buildFail(ErrorMsgEnum errorMsgEnum,Object object) {
        return CommonResult.builder()
                .success(StatusEnum.FAIL.isStatus())
                .code(errorMsgEnum.getCode())
                .msg(errorMsgEnum.getMsg())
                .data(object)
                .build();
    }

    public static CommonResult buildFail(ErrorMsgEnum errorMsgEnum,Object object,String ... arg) {
        String msg = getMsg(errorMsgEnum.getMsg(),arg);
        return CommonResult.builder()
                .success(StatusEnum.FAIL.isStatus())
                .code(errorMsgEnum.getCode())
                .msg(msg)
                .data(object)
                .build();
    }

    public static CommonResult build(boolean status,String code,String msg) {
        return CommonResult.builder()
                .success(status)
                .code(code)
                .msg(msg)
                .build();
    }

    public static CommonResult build(boolean status,String code,String msg,String... arg) {
        msg = getMsg(msg,arg);
        return CommonResult.builder()
                .success(StatusEnum.FAIL.isStatus())
                .code(code)
                .msg(msg)
                .build();
    }

    private static String getMsg(String msg,String... arg){
        if(msg.contains("{}")){
            for (String value : arg) {
                msg = msg.replace("{}",value);
            }
        }else{
            msg = msg + Arrays.toString(arg);
        }
        return msg;
    }
}
