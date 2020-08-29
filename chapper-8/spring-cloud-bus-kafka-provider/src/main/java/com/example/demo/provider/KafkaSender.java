package com.example.demo.provider;

import com.example.demo.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ay
 * @since 2020-08-09
 */
@Component
public class KafkaSender {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    public void send(Long id) {
        Message message = new Message();
        message.setId(id);
        message.setMsg("hello, ay");
        message.setSendTime(new Date());
        kafkaTemplate.send("test", "message");
    }
}
