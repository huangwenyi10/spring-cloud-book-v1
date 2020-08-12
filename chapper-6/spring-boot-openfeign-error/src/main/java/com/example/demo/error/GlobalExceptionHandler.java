package com.example.demo.error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：全局异常处理
 * @author:ay
 * @since :2020-08-04
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常处理器
     * @param throwable
     * @param request
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result systemExceptionHandler(Throwable throwable, HttpServletRequest request) {
        log.error("URL：{} ,系统异常", request.getRequestURI(), throwable);
        return Result.fail("系统异常", ResultCode.SYSTEM_EXCEPTION.getCode());
    }

    /**
     * 自定义异常处理器
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result baseExceptionHandler(BaseException baseException, HttpServletRequest request) {
        log.warn("URL：{} ,业务异常", request.getRequestURI());
        return Result.fail(baseException.getMsg(), baseException.getCode());
    }

}