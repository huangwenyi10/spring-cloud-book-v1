package com.example.demo.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author ay
 * @since 2020-04-26
 */
public interface MQSource {

    String OUTPUT = "ay-topic";

    /**
     * 指定TOPIC
     *
     * @return
     */
    @Output(MQSource.OUTPUT)
    MessageChannel output();


    String OUTPUT_2 = "ay-topic-2";

    @Output(MQSource.OUTPUT_2)
    MessageChannel output2();

    String OUTPUT_3 = "ay-topic-3";

    @Output(MQSource.OUTPUT_3)
    MessageChannel output3();

    String OUTPUT_4 = "ay-topic-4";

    @Output(MQSource.OUTPUT_4)
    MessageChannel output4();

    String OUTPUT_5 = "ay-topic-5";

    @Output(MQSource.OUTPUT_5)
    MessageChannel output5();


}
