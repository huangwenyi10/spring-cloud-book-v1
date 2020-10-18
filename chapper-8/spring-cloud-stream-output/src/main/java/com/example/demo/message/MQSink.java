package com.example.demo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/10/13
 */
public interface MQSink {


    String INPUT_5 = "back-ay-topic-5";

    @Output(MQSink.INPUT_5)
    SubscribableChannel input5();
}
