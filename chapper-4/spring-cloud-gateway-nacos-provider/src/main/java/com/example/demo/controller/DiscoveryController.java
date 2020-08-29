package com.example.demo.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/example/discovery")
public class DiscoveryController {
    @NacosInjected
    private NamingService namingService;

    /**
     * 第一个例子：测试请求通过网关，能否代理到service-01 的 /example/discovery/get方法上
     *
     * @param serviceName
     * @param request
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName, HttpServletRequest request) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    /**
     * 第二个例子：测试网关添加请求头
     *
     * @param request
     * @return
     * @throws NacosException
     */
    @RequestMapping(value = "/get2", method = GET)
    @ResponseBody
    public String get2(HttpServletRequest request) throws NacosException {
        //控制台打印blue
        System.out.println(request.getHeader("X-Request-red"));
        return "success";
    }
}