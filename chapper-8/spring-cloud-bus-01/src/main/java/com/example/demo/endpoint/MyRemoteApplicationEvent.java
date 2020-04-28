package com.example.demo.endpoint;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 *
 *
 * @author ay
 * @since 2020-04-26
 */
public class MyRemoteApplicationEvent extends RemoteApplicationEvent {

    public MyRemoteApplicationEvent(Object source, String originService, String destinationService) {
        super(source, originService, destinationService);
    }
}
