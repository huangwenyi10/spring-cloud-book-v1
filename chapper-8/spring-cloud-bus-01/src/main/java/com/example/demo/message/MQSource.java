package com.example.demo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author ay
 * @desc
 * @since  2020-04-26
 */
public interface MQSource {

  String OUTPUT = "accessLog";

  /**
   * 指定TOPIC
   * @return
   */
  @Output(MQSource.OUTPUT)
  MessageChannel output();

}
