package com.example.demo.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 描述：
 * @author ay
 * @since 2020/04/20
 */
@RestController
@RequestMapping("/redis")
public class RedisOpsController{

  @Resource
  RedisTemplate redisTemplate;

  @GetMapping("/get/{key}")
  public void get(@PathVariable("key") String key){
    //redisTemplate.setKeySerializer(new StringRedisSerializer());
    //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    redisTemplate.opsForValue().get(key);
  }

}
