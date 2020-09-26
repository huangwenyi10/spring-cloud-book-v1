package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * 描述：
 *
 * @author ay
 * @since 2020/9/13
 */
@Component
public class UserServiceImpl implements UserService {

    Logger log = Logger.getLogger("");

    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "getDefaultUser", commandKey = "getUserCache")
    public String getUserCache(Long id) {
        log.info("getUserCache id:"+id);
        //数据库查询用户数据
        return "";
    }

    /**
     * 为缓存生成key的方法
     */
    public String getCacheKey(Long id) {
        return String.valueOf(id);
    }

    /**
     * 清除缓存
     * @param id
     * @return
     */
    @CacheRemove(commandKey = "getUserCache", cacheKeyMethod = "getCacheKey")
    @HystrixCommand
    public String removeCache(Long id) {
        log.info("removeCache id:" + id);
        return "";
    }

    @HystrixCollapser(batchMethod = "getUserByIds",scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")
    })
    @Override
    public User getUserById(Long id) {
        //模拟查询数据库
        User user = new User();
        user.setId(id);
        log.info("getUserById,id:" + id);
        return user;
    }


    @HystrixCommand
    @Override
    public List<User> getUserByIds(List<Long> ids) {
        log.info("getUserByIds,ids:" + ids);
        List<User> users = new ArrayList<>();
        //模拟查询数据库
        for(Long id: ids){
            User user = new User();
            user.setId(id);
            users.add(user);
        }
        return users;
    }
}
