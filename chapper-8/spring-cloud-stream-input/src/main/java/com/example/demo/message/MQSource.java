package com.example.demo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/10/13
 */
public interface MQSource {

    String OUT_PUT_5 = "back-ay-topic-5";

    @Output(MQSource.OUT_PUT_5)
    MessageChannel output5();
}
