package com.example.demo.error;
import lombok.Data;
import java.io.Serializable;

/**
 * 描述：封装result对象
 * @author ay
 * @since 2020-08-04
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    public Result(){}
    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T> Result<T> success(String msg) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), msg, null);
    }
    public static <T> Result<T> success(T model, String msg) {
        return new Result<>(ResultCode.SUCCESS.getCode(), msg, model);
    }
    public static <T> Result<T> fail(String msg, Integer code) {
        return new Result<>(code, msg, null);
    }
}
