package com.taosha.summaryframework.verify.controller;

import com.taosha.summaryframework.commonResult.ServiceException;
import com.taosha.summaryframework.commonResult.enums.ErrorMsgEnum;
import com.taosha.summaryframework.verify.annotations.Encrypt;
import com.taosha.summaryframework.verify.bean.People;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 2:05 PM
 **/
@RestController
@RequestMapping(value = "/verify")
public class VerifyController {

    @PostMapping
    @Encrypt
    public String verifyPeople(@Validated @RequestBody People people){
        System.out.println("加密 : " + people);
        return people.toString();
    }

    @PostMapping("/send")
    public Object verifyPeople1(){
        throw ServiceException.fromEnum(ErrorMsgEnum.SYSTEM_ERROR);
    }
}
