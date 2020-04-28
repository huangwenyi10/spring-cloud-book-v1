package com.example.demo.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：
 *
 * @author ay
 * @since 2020-04-27
 */
@RestController
@RequestMapping("/db")
public class DBController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/get")
    public void get(){
        String sql = "select * from gateway_route";
        jdbcTemplate.queryForList(sql);
    }
}
