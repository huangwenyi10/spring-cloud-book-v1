package com.example.demo.error;

import lombok.Data;

/**
 * 描述：自定义异常
 *
 * @author:ay
 * @since :2020-08-04
 */
@Data
public class BaseException extends RuntimeException {

    private Integer code;
    private String msg;

    public BaseException() {
        super();
    }

    public BaseException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

}