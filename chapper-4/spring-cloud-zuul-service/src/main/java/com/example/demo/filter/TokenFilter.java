package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器
 *
 * @author ay
 * @since 2020-07-03
 */
@Component
public class TokenFilter extends ZuulFilter {

    public boolean shouldFilter() {
        //判断过滤器是否生效，true代表生效
        return true;
    }

    //具体的过滤执行逻辑
    public Object run() throws ZuulException {
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //从请求头获取token的参数
        String userToken = request.getParameter("token");
        if (StringUtils.isEmpty(userToken)) {
            //返回错误提示
            //false：表示不会继续往下执行，不会调用服务接口，直接响应给客户
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("token is null!!!");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //否则正常执行 调用服务接口...
        return null;
    }

    @Override
    public String filterType() {
        //定义过滤器的类型，pre表示在请求被路由前执行
        return "pre";
    }

    @Override
    public int filterOrder() {
        //返回int数据，用于为同filterType的多个过滤器定制执行顺序，返回值越小，执行顺序越优先
        return 0;
    }
}