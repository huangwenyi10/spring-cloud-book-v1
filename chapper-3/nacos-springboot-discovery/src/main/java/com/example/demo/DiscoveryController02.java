package com.example.demo;

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
public class DiscoveryController02 {
    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName, HttpServletRequest request) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    @RequestMapping(value = "/get2", method = GET)
    @ResponseBody
    public List<Instance> get2(@RequestParam String serviceName, HttpServletRequest request) throws NacosException {
        System.out.println(request.getHeader(""));
        return namingService.getAllInstances(serviceName);
    }
}