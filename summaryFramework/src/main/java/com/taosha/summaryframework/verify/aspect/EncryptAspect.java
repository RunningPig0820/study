package com.taosha.summaryframework.verify.aspect;

import com.taosha.summaryframework.verify.annotations.Encrypt;
import com.taosha.summaryframework.verify.utils.AesUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-14 3:50 PM
 **/
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EncryptAspect {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${secretkey}")
    private String secretKey;

    @Pointcut("@annotation(com.taosha.summaryframework.verify.annotations.Encrypt)")
    public void annotationPointCut() {
    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object responseObj = null;
        try {
            Object requestObj = joinPoint.getArgs()[0];
            handleEncrypt(requestObj);
//            TODO 自定义是否解密
//            handleDecrypt(responseObj);
            responseObj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("SecureFieldAop处理出现异常{}", throwable);
        }
        return responseObj;
    }

    /**
     * 处理加密
     *
     * @param requestObj
     */
    private void handleEncrypt(Object requestObj) throws IllegalAccessException {
        if (Objects.isNull(requestObj)) {
            return;
        }
        Field[] fields = requestObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(Encrypt.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String plaintextValue = (String) field.get(requestObj);
                String encryptValue = AesUtil.encrypt(plaintextValue, secretKey);
                field.set(requestObj, encryptValue);
            }
        }
    }

    /**
     * 处理解密
     *
     * @param responseObj
     */
    private Object handleDecrypt(Object responseObj) throws IllegalAccessException {
        if (Objects.isNull(responseObj)) {
            return null;
        }

        Field[] fields = responseObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(Encrypt.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String encryptValue = (String) field.get(responseObj);
                String plaintextValue = AesUtil.decrypt(encryptValue, secretKey);
                field.set(responseObj, plaintextValue);
            }
        }
        return responseObj;
    }
}
