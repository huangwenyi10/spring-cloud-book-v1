package com.example.demo.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/10/13
 */
@EnableBinding(value = {MQSink.class})
public class BackMsgHandler {

    @StreamListener(MQSink.INPUT_5)
    public void backMsg(String json){
        System.out.println(json);
    }

}
