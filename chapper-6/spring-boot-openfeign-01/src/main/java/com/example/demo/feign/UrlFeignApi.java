package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述：TestFeignApi
 *
 * @author ay
 * @since 2020-08-03
 */
@FeignClient(value = "url-service", url = "http://localhost:8080")
public interface UrlFeignApi {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test();
}
