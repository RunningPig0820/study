package com.taosha.summaryframework.commonResult.utils;

import com.google.common.base.Strings;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 7:58 PM
 **/
public class RequestIpExtractor {
    private static final String[] HEADERS_TO_TRY = new String[]{"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR"};

    public RequestIpExtractor() {
    }

    public static String getClientIp(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (!Strings.isNullOrEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
}
