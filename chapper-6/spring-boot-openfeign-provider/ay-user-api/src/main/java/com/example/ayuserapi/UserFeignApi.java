package com.example.ayuserapi;

import feign.Param;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * 描述：用户接口
 *
 * @author ay
 * @since 2020-07-24
 */
@FeignClient(name = "service-provider", configuration = LogConfiguration.class)
//@FeignClient(name = "service-provider")
public interface UserFeignApi {

    @RequestMapping("/getUserName")
    String getUserName();

    @GetMapping(path = "/demo")
    String demoEndpoint(@SpringQueryMap Params params);

    @CollectionFormat(feign.CollectionFormat.CSV)
    @GetMapping(value = "/search/findByIdIn")
    String getByIds(@RequestParam("ids") Long[] ids);
}

//参考文章：
// https://www.cnblogs.com/smiler/p/10689894.html
// https://blog.csdn.net/weixin_38809962/article/details/80354878
