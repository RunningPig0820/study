package com.taosha.summaryframework.commonResult.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 统一的返回来袭
 * @Author : zhangmin
 * @Data 2019-08-13 5:15 PM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResult<T> {
    /**
     * 只有code = '0000'才返回true,其余返回false
     */
    private boolean success;

    /**
     * 业务code
     */
    private String code;

    /**
     * 描述语
     */
    private String msg;

    /**
     * 模型返回值
     */
    private T data;
}
