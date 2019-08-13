package com.taosha.summaryframework.commonResult.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ErrorMsgEnum {
    //
    SUCCESS("0000","成功"),

    SYSTEM_ERROR("999", "系统错误"),

    PARAMETER_VALID_NOT_PASS("500","参数校验不通过"),

    MISSING_REQUEST_PARAMETER("4000","缺少请求参数"),

    BAD_REQUEST("4001","请求不正确"),

    UNAUTHORIZED("4002","鉴权失败"),
    TOKEN_EXPIRED("4003","TOKEN已过期"),
    TOKEN_TYPE_NOT_MATCH("4004","TOKEN类型不匹配"),
    METHOD_ARGUMENT_NOT_VALID("4005","请求参数不正确"),
    MISSING_SERVLET_REQUEST_PARAMETER("4006","缺少参数"),
    MEDIA_TYPE_NOT_SUPPORTED("4007","不支持的媒体类型"),
    PARAM_UNRECOGNIZED("4008","无法识别的属性"),
    PARAM_INVALID_FORMAT("4009","值[{}]不是有效的[{}]类型"),
    ILLEGAL_ARGUMENT("4010","非法参数"),
    IP_INVALID("4011","无效的IP"),
    RATE_LIMIT_EXCEED("4012","访问超限"),

    BASIC_ERROR("5000",""),
    SOCKET_EXCEPTION("5001","内部异常"),
    SOCKET_TIMEOUT("5002","内部异常"),
    THIRD_PARTY_EXCEPTION("5003","三方接口异常"),
    CLIENT_EXCEPTION("5004","三方服务异常"),
    SERVICE_SHUTTING("5005","内部异常"),
    SERVER_ERROR("5006","内部异常"),

  ;

    private String code;
    private String msg;

}
