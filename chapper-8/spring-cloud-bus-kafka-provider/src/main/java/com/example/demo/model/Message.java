package com.example.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 消息实体
 * @author ay
 * @since 2020-08-09
 */
@Data
public class Message {
    private Long id;
    private String msg;
    private Date sendTime;
}
