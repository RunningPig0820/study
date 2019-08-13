package com.taosha.summaryframework.verify.bean;

import com.taosha.summaryframework.verify.common.Regexes;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 1:51 PM
 **/
@Data
public class People {

    @NotNull(message = "name 字段为空")
    private String name;

    @NotNull(message = "age 字段为空")
    @Min(value = 18,message = "年龄限制在 [18,30]")
    @Max(value = 30,message = "年龄限制在 [18,30]")
    private Integer age;

    @NotNull(message = "idCard 字段为空")
    private String idCard;

    @NotNull(message = "mobile 字段为空")
    @Pattern(regexp = Regexes.MOBILE, message = "手机号码或邮箱格式错误")
    private String mobile;



}
