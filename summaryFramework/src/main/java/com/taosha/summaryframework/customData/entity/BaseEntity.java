package com.taosha.summaryframework.customData.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taosha.summaryframework.customData.annotation.FieldName;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-15 11:42 AM
 **/
public class BaseEntity {

    @JsonIgnore
    public Map<String, String> getEntityToDbMap() {
        Map<String,String> map = new HashMap<>();
        Class<?> clazz = getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            Field.setAccessible(fields, true);
            for (Field field : fields) {
                String key = field.getName();
                boolean fieldHasAnno = field.isAnnotationPresent(FieldName.class);
                if (fieldHasAnno) {
                    FieldName fieldName = field.getAnnotation(FieldName.class);
                    //对应的数据库字段名
                    key = fieldName.name();
                }
                map.put(field.getName(),key);
            }
        } catch (Exception ignored) {
        }
        return  map;
    }
}
