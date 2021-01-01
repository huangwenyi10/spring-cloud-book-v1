package com.ay.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：Mybatis配置类
 * @author ay
 * @since 2020-09-17
 */
@Configuration
@MapperScan({"com.ay.cloud.dao"})
public class MyBatisConfig {
}
