package com.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 描述：
 * @author ay
 * @since 2020-08-09
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            System.out.println(message);
        }
    }
}
