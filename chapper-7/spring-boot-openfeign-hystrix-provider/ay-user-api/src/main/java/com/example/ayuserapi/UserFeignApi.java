package com.example.ayuserapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//参考文章：https://www.cnblogs.com/smiler/p/10689894.html

/**
 * @author ay
 * @since 2020-07-23
 */
@FeignClient(contextId = "userFeignApi", value = "service-provider", configuration = FallBackConfiguration.class,
        fallback = FeignClientFallback.class)
public interface UserFeignApi {

    @RequestMapping("/getUserName")
    String getUserName();

}
