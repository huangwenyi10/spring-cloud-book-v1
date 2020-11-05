package com.example.demo.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ay
 */
public interface MqSink {

    String INPUT = "ay-topic";

    /**
     * 消费者接口
     */
    @Input(MqSink.INPUT)
    SubscribableChannel input();


    String INPUT_2 = "ay-topic-2";

    @Input(MqSink.INPUT_2)
    SubscribableChannel input2();

    String INPUT_3 = "ay-topic-3";

    @Input(MqSink.INPUT_3)
    SubscribableChannel input3();

    String INPUT_4 = "ay-topic-4";

    @Input(MqSink.INPUT_4)
    SubscribableChannel input4();

    String INPUT_5 = "ay-topic-5";

    @Input(MqSink.INPUT_5)
    SubscribableChannel input5();

}
