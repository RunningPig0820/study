package com.taosha.summaryframework.customData.annotation;

import java.lang.annotation.*;

//注解可继承
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldName {
    String name() default "";
}
