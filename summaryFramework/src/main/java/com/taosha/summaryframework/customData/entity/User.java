package com.taosha.summaryframework.customData.entity;

import com.taosha.summaryframework.customData.annotation.FieldName;

import java.sql.Date;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-15 11:57 AM
 **/
public class User extends BaseEntity{

    @FieldName(name = "USE_ID")
    private long useId;

    @FieldName(name = "USE_NAME")
    private String useName;

    @FieldName(name = "USE_SEX")
    private String useSex;

    @FieldName(name = "USE_AGE")
    private Integer useAge;

    @FieldName(name = "USE_ID_NO")
    private String useIdNo;

    @FieldName(name = "USE_PHONE_NUM")
    private String usePhoneNum;

    @FieldName(name = "USE_EMAIL")
    private String useEmail;

    @FieldName(name = "CREATE_TIME")
    private Date createTime;

    @FieldName(name = "MODIFY_TIME")
    private Date modifyTime;

    @FieldName(name = "USE_STATE")
    private String useState;
}
