package com.taosha.summaryframework.customException;

import com.taosha.summaryframework.customException.enums.ErrorMsgEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.slf4j.event.Level;

import java.util.Arrays;
import java.util.Objects;


/**
 * @Description : 自定义异常类
 * @Author : zhangmin
 * @Data 2019-07-15 5:50 PM
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {
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

    public static ServiceException fromEnum(ErrorMsgEnum errorMsgEnum) {
        return new ServiceException(errorMsgEnum);
    }

    public static ServiceException fromEnum(ErrorMsgEnum errorMsgEnum, String... arg) {
        return new ServiceException(errorMsgEnum,arg);
    }
}