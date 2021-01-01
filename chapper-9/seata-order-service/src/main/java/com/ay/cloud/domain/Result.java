package com.ay.cloud.domain;

/**
 * 描述：统一响应结果
 * @author ay
 * @since 2020-09-17
 */
public class Result<T> {
    private T data;
    private String message;
    private Integer code;

    public Result() {
    }

    public Result(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result(String message, Integer code) {
        this(null, message, code);
    }

    public Result(T data) {
        this(data, "操作成功", 200);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}