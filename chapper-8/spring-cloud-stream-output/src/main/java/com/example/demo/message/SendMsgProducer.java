package com.example.demo.message;

import com.example.demo.model.AyUser;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author ay
 * @date 2020-04-26
 */
@EnableBinding({MQSource.class})
public class SendMsgProducer {

    @Resource
    private MQSource mQSource;

    public void sendMessage(String msg) {
        try {
            mQSource.output().send(MessageBuilder.withPayload(msg).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Resource(name = MQSource.OUTPUT_2)
    private MessageChannel messageChannel;

    public void sendMessage2(String msg){
        try{
            messageChannel.send(MessageBuilder.withPayload(msg).build());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Resource(name = MQSource.OUTPUT_4)
    private MessageChannel messageChannel_4;

    public void sendMessage4(){
        try{
            AyUser user = new AyUser(1, "ay");
            messageChannel_4.send(MessageBuilder.withPayload(user).build());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Resource(name = MQSource.OUTPUT_5)
    private MessageChannel messageChannel_5;

    public void sendMessage5(){
        try{
            AyUser user = new AyUser(1, "ay");
            messageChannel_5.send(MessageBuilder.withPayload(user).build());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
