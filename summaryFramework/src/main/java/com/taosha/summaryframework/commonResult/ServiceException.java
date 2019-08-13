package com.taosha.summaryframework.commonResult;

import com.taosha.summaryframework.common.StatusEnum;
import com.taosha.summaryframework.commonResult.bean.CommonResult;
import com.taosha.summaryframework.commonResult.enums.ErrorMsgEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;


/**
 * @Description : 返回处理类
 * @Author : zhangmin
 * @Data 2019-07-15 5:50 PM
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException{
    @Getter
    private String errCode;

    @Getter
    private String errMsg;

    @Getter
    private ErrorMsgEnum errorMsgEnum;

    public ServiceException(String errCode) {
        this.errCode = errCode;
    }

    public ServiceException(String errCode, Throwable throwable) {
        super(throwable);
        this.errCode = errCode;
    }

    public ServiceException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
        this.errMsg = message;
    }

    public ServiceException(String errCode, String message, String... arg) {
        super(message);
        this.errCode = errCode;
        this.errMsg = message + Arrays.toString(arg);
    }

    public ServiceException(ErrorMsgEnum errorMsgEnum) {
        super(errorMsgEnum.getMsg());
        this.errorMsgEnum = errorMsgEnum;
        this.errCode = errorMsgEnum.getCode();
        this.errMsg = errorMsgEnum.getMsg();
    }

    public ServiceException(ErrorMsgEnum errorMsgEnum, String... arg) {
        super(errorMsgEnum.getMsg());
        this.errorMsgEnum = errorMsgEnum;
        this.errCode = errorMsgEnum.getCode();
        this.errMsg = errorMsgEnum.getMsg()+ Arrays.toString(arg);
    }

    public ServiceException(String errCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errCode = errCode;
        this.errMsg = message;
    }

    public static ServiceException fromEnum(ErrorMsgEnum errorKey) {
        return new ServiceException(errorKey);
    }

    public static ServiceException fromEnum(ErrorMsgEnum errorKey, String... args) {
        return new ServiceException(errorKey,args);
    }
}


