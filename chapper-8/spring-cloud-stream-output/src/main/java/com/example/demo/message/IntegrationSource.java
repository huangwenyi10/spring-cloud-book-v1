package com.example.demo.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/10/3
 */
@EnableBinding(Source.class)
public class IntegrationSource {

//    @Bean
//    @InboundChannelAdapter(value = MQSource.OUTPUT_3, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
//    public MessageSource<String> timerMessageSource() {
//        return () -> new GenericMessage<>(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//    }


//    @Bean
//    @InboundChannelAdapter(value = MQSource.OUTPUT_3, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
//    public MessageSource<Date> timerMessageSource() {
//        //return () -> new GenericMessage<>(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        return () -> new GenericMessage<>(new Date());
//    }
}
