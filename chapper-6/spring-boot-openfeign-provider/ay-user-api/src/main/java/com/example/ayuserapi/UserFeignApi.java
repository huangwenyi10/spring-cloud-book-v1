package com.example.ayuserapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：用户接口
 * @author ay
 * @since 2020-07-24
 */
@FeignClient(name = "service-provider", configuration = LogConfiguration.class)
//@FeignClient(name = "service-provider")
public interface UserFeignApi {

    @RequestMapping("/getUserName")
    String getUserName();
}

//参考文章：
// https://www.cnblogs.com/smiler/p/10689894.html
// https://blog.csdn.net/weixin_38809962/article/details/80354878
