package com.taosha.summaryframework.commonResult.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.taosha.summaryframework.commonResult.ServiceException;
import com.taosha.summaryframework.commonResult.bean.CommonResult;
import com.taosha.summaryframework.commonResult.enums.ErrorMsgEnum;
import com.taosha.summaryframework.commonResult.utils.RequestIpExtractor;
import com.taosha.summaryframework.commonResult.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.rmi.ServerException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

/**
 * @Description : 统一异常处理类
 * 只能捕获 关于 @RequestMapping注解的方法。
 * @Author : zhangmin
 * @Data 2019-08-13 3:51 PM
 **/
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public CommonResult validationError(ServiceException serviceException, HttpServletResponse resp) {
        return ResultUtils.build(false,serviceException.getErrCode(),serviceException.getErrMsg());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public CommonResult validationError(MethodArgumentNotValidException e, HttpServletResponse resp) {
        Method method = e.getParameter().getMethod();
        String methodInfo = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        StringBuilder buf = new StringBuilder();
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        IntStream.range(0, errors.size()).forEach((index) -> {
            if (index != 0) {
                buf.append(",");
            }

            FieldError error = (FieldError) errors.get(index);
            String message = error.getDefaultMessage();
            if (!StringUtils.isEmpty(message) && error.getRejectedValue() != null) {
                message = message.replace("{}", error.getRejectedValue().toString());
            }

            buf.append(message);
        });
        log.error("异常:{}", buf.toString());
        return ResultUtils.buildFail(ErrorMsgEnum.PARAMETER_VALID_NOT_PASS,buf);
    }

// 未测试
//    @ExceptionHandler({ConstraintViolationException.class})
//    public CommonResult constraintViolation(ConstraintViolationException e, HttpServletResponse resp) {
//        StringBuilder buf = new StringBuilder();
//        ConstraintViolation[] constraints = (ConstraintViolation[])e.getConstraintViolations().toArray(new ConstraintViolation[0]);
//        IntStream.range(0, constraints.length).forEach((index) -> {
//            if (index != 0) {
//                buf.append(",");
//            }
//
//            String message = constraints[index].getMessage();
//            if (!StringUtils.isEmpty(message) && constraints[index].getInvalidValue() != null) {
//                message = message.replace("{}", constraints[index].getInvalidValue().toString());
//            }
//
//            buf.append(message);
//        });
//        log.error("异常:{}", buf.toString());
//        return ResultUtils.buildFail(ErrorMsgEnum.SYSTEM_ERROR,buf);
//    }
//
//    @ExceptionHandler({BindException.class})
//    public CommonResult bindException(BindException e, HttpServletResponse resp) {
//        StringBuilder msg = new StringBuilder();
//        IntStream.range(0, e.getFieldErrorCount()).forEach((index) -> {
//            if (index != 0) {
//                msg.append(",");
//            }
//
//            FieldError error = (FieldError)e.getFieldErrors().get(index);
//            msg.append(error.getField()).append(":").append(error.getDefaultMessage());
//        });
//        log.error("异常:{}", msg);
//        return ResultUtils.buildFail(ErrorMsgEnum.SYSTEM_ERROR,msg);
//    }
//
//    @ExceptionHandler({MissingServletRequestParameterException.class})
//    public CommonResult missingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletResponse resp) {
//        log.error("异常:{}", e);
//        return ResultUtils.buildFail(ErrorMsgEnum.SYSTEM_ERROR,e.getParameterName());
//    }
//
//    @ExceptionHandler({HttpMessageNotReadableException.class, TypeMismatchException.class})
//    public CommonResult messageException(Exception e, HttpServletResponse resp) {
//        if (e.getCause() != null && e.getCause() instanceof UnrecognizedPropertyException) {
//            String propName = ((UnrecognizedPropertyException)e.getCause()).getPropertyName();
//            log.error("无法识别的属性[{}]", propName);
//            return ResultUtils.buildFail(ErrorMsgEnum.PARAM_UNRECOGNIZED,propName);
//        } else if (e.getCause() != null && e.getCause() instanceof InvalidFormatException) {
//            InvalidFormatException cause = (InvalidFormatException)e.getCause();
//            String value = cause.getValue().toString();
//            String targetCls = cause.getTargetType().getSimpleName();
//            log.error("值[{}]不是有效的[{}]类型", value, targetCls);
//            return ResultUtils.buildFail(ErrorMsgEnum.PARAM_INVALID_FORMAT,value,targetCls);
//        } else {
//            log.error(ExceptionUtils.getStackTrace(e));
//        }
//        return ResultUtils.buildFail(ErrorMsgEnum.SYSTEM_ERROR);
//    }
//
//    @ExceptionHandler({HttpMediaTypeNotSupportedException.class, HttpMediaTypeNotAcceptableException.class})
//    public CommonResult badRequest(Exception e, HttpServletResponse resp) {
//        log.error(e.getMessage());
//        return ResultUtils.buildFail(ErrorMsgEnum.MEDIA_TYPE_NOT_SUPPORTED);
//    }
//
//    @ExceptionHandler({IllegalArgumentException.class})
//    public CommonResult illegalArgument(IllegalArgumentException e, HttpServletResponse resp) {
//        log.error(e.getMessage());
//        return ResultUtils.buildFail(ErrorMsgEnum.MEDIA_TYPE_NOT_SUPPORTED);
//    }
//
//    @ExceptionHandler({SocketException.class})
//    public CommonResult socketException(SocketException e, HttpServletResponse resp) {
//        log.error(ExceptionUtils.getStackTrace(e));
//        return ResultUtils.buildFail(ErrorMsgEnum.SOCKET_EXCEPTION);
//    }
//
//    @ExceptionHandler({TimeoutException.class, SocketTimeoutException.class})
//    public CommonResult socketTimeoutException(Exception e, HttpServletResponse resp) {
//        log.warn("请求超时");
//        return ResultUtils.buildFail(ErrorMsgEnum.SOCKET_TIMEOUT);
//    }
//
//
//    @ExceptionHandler({ServerException.class})
//    public CommonResult serverException(ServerException e, HttpServletResponse resp) {
//        log.error(ExceptionUtils.getStackTrace(e));
//        return ResultUtils.buildFail(ErrorMsgEnum.SOCKET_TIMEOUT);
//    }
//
//
//    @ExceptionHandler({NoHandlerFoundException.class})
//    public CommonResult noHandlerFoundException(NoHandlerFoundException e, HttpServletRequest request) {
//        log.warn("[{}]请求了不存在的接口:{}", RequestIpExtractor.getClientIp(request), e.getRequestURL());
//        return ResultUtils.buildFail(ErrorMsgEnum.SOCKET_TIMEOUT);
//
//    }
//
//    @ExceptionHandler({ServletRequestBindingException.class})
//    public CommonResult servletRequestBindingException(ServletRequestBindingException e, HttpServletResponse resp) {
//        return ResultUtils.buildFail(ErrorMsgEnum.METHOD_ARGUMENT_NOT_VALID,e.getMessage());
//
//    }
//
//    @ExceptionHandler({Throwable.class})
//    public CommonResult unknownError(Throwable e, HttpServletResponse resp) {
//        if (e.getClass().getName().contains("ClientException")) {
//            log.error("调用client异常:{}", e.getMessage());
//            return ResultUtils.buildFail(ErrorMsgEnum.CLIENT_EXCEPTION,e.getMessage());
//
//        } else {
//            log.error("发生未知的异常", e);
//            return ResultUtils.buildFail(ErrorMsgEnum.SERVER_ERROR,e.getMessage());
//        }
//
//    }

}
