package com.example.demo.controller;

/**
 * 描述：限流
 *
 * @author ay
 * @since 2020-07-24
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：限流功能
 * @author ay
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 按资源名称限流，需要指定限流处理逻辑
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", fallback = "handleException")
    public CommonResult byResource() throws Exception {
        Thread.sleep(5000);
        return new CommonResult("按资源名称降级", 200);
    }

    public CommonResult handleException() {
        return new CommonResult("降级了", 200);
    }

}
