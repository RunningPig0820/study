package com.taosha.summaryframework.customException;

import org.junit.Test;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 11:51 AM
 **/
public class ExceptionTest {

    @Test
    public void test_normal(){
//        throw ServiceException.fromEnum(ErrorMsgEnum.SYSTEM_ERROR);
    }

    @Test
    public void test_normal_arg(){
//        throw ServiceException.fromEnum(ErrorMsgEnum.PARAMETER_VALID_NOT_PASS,"姓名","年龄");
    }

    @Test
    public void test_arg_null(){
//        throw ServiceException.fromEnum(ErrorMsgEnum.SYSTEM_ERROR,"");
    }
}
