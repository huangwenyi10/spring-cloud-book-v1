package com.example.demo.error;

import lombok.Data;

/**
 * 描述：封装错误码
 * @author:ay
 * @since :2020-08-04
 */
public enum ResultCode {

    SUCCESS(0000, "成功"),
    FAIL(9999, "失败"),
    SYSTEM_EXCEPTION(4000, "系统异常");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}