package com.example.demo.message;

import com.example.demo.model.AyUser;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author ay
 * @date 2020/03/17
 */
@EnableBinding(value = {MqSink.class, MQSource.class})
public class MqSinkReceiver {

    @StreamListener(MqSink.INPUT)
    public void messageListen(String json) {
        //处理请求的类，对消息进行处理
        System.out.println(json);
    }

    @StreamListener(MqSink.INPUT_2)
    public void messageListen2(String json) {
        //处理请求的类，对消息进行处理
        System.out.println(json);
    }

    @ServiceActivator(inputChannel = MqSink.INPUT_3)
    public void messageListen3(String json){
        System.out.println(json);
    }

    @Transformer(inputChannel = MqSink.INPUT_3, outputChannel = MqSink.INPUT_3)
    public Object transform(Date message){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(message);
    }

    @ServiceActivator(inputChannel = MqSink.INPUT_4)
    public void messageListen4(@Payload AyUser user, @Headers Map headers){
        System.out.println(user.toString());
        System.out.println(headers.toString());
    }


    @StreamListener(MqSink.INPUT_5)
    @SendTo(MQSource.OUT_PUT_5)
    public String messageListen5(@Payload AyUser user, @Headers Map headers){
        System.out.println(user.toString());
        System.out.println(headers.toString());
        return "success!!!";
    }


}
