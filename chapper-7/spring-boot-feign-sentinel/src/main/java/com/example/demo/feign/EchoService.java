package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ay
 * @since 2020-04-22
 */
@FeignClient(name = "openfeign-sentinel", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface EchoService {

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    String echo(@PathVariable("str") String str);

}