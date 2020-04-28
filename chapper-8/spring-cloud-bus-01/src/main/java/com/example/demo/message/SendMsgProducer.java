package com.example.demo.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author ay
 * @desc
 * @date 2020-04-26
 */
@EnableBinding(MQSource.class)
public class SendMsgProducer {

  @Resource
  private MQSource MQSource;

  public void sendMessage(String msg) {
    try {
      MQSource.output().send(MessageBuilder.withPayload(msg).build());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
