package com.example.demo.error;

import com.alibaba.fastjson.JSONObject;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义Feign异常处理
 * @author:ay
 * @since :2020-08-04
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        BaseException baseException = null;
        try {
            String errorContent = Util.toString(response.body().asReader());
            Result result = JSONObject.parseObject(errorContent, Result.class);
            baseException = new BaseException(result.getCode(), result.getMsg());
        } catch (Exception ignore) {

        }
        return baseException;
    }
}