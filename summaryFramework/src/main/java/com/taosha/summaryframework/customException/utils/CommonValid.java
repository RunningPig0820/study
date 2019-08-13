package com.taosha.summaryframework.customException.utils;

import com.taosha.summaryframework.customException.ServiceException;
import com.taosha.summaryframework.customException.enums.ErrorMsgEnum;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 11:33 AM
 **/
public class CommonValid {public static void validNotNull(Object o, ErrorMsgEnum errorKey, String... args){
    if(o == null) {
        throw ServiceException.fromEnum(errorKey, args);
    }
}

    public static void validNull(Object o, ErrorMsgEnum errorKey, String... args){
        if(o != null) {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static void validNotEmpty(Collection collection, ErrorMsgEnum errorKey, String... args){
        if(collection == null || collection.size() == 0) {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static void validNotEmpty(Map map, ErrorMsgEnum errorKey, String... args){
        if(map == null || map.size() == 0) {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static void validNotEmpty(Object[] o, ErrorMsgEnum errorKey, String... args) {
        if (o == null || o.length == 0)  {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static void validEmpty(Collection collection, ErrorMsgEnum errorKey, String... args){
        if(CollectionUtils.isNotEmpty(collection)) {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static void validEqual(Object o1, Object o2, ErrorMsgEnum errorKey, String... args){

        if(o1 == null || o2 == null || !o1.equals(o2)) {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static void validNotEqual(Object o1, Object o2, ErrorMsgEnum errorKey){

        if((o1 == null && o2 == null) || (o1 != null && o1.equals(o2))) {
            throw ServiceException.fromEnum(errorKey);
        }
    }

    public static void validNotBlank(String obj, ErrorMsgEnum errorKey){
        if(obj == null || obj.isEmpty()) {
            throw ServiceException.fromEnum(errorKey);
        }
    }

    public static void validTrue(Boolean obj, ErrorMsgEnum errorKey, String... args){
        if(obj == null || !obj) {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static void validFalse(Boolean obj, ErrorMsgEnum errorKey, String... args){
        if(obj != null && obj) {
            throw ServiceException.fromEnum(errorKey, args);
        }
    }

    public static List<String> transferArgument(String str, ErrorMsgEnum errorKey) {
        if(StringUtils.isEmpty(str)) {
            throw ServiceException.fromEnum(errorKey);
        }
        String[] arr = str.split(",");
        return Arrays.asList(arr);
    }
}
