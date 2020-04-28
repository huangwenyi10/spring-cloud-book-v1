package com.example.demo.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author Trazen
 * @desc 处理请求日志
 * @date 2020/03/17
 */
@EnableBinding(value = {MqSink.class})
public class MqSinkReceiver {

    @StreamListener(MqSink.INPUT)
    public void messageListen(String json) {
      //处理请求的类，对消息进行处理
      System.out.println(json);
    }
}
