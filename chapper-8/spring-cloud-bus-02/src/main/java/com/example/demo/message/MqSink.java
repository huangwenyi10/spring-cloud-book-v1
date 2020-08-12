package com.example.demo.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ay
 */
public interface MqSink {

  String INPUT = "accessLog";

  /**
   * 消费者接口
   *
   * @return org.springframework.messaging.SubscribableChannel 接口对象
   */
  @Input(MqSink.INPUT)
  SubscribableChannel input();


}
