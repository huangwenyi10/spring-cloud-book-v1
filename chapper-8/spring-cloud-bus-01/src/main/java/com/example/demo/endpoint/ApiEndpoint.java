package com.example.demo.endpoint;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.cloud.bus.endpoint.AbstractBusEndpoint;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ay
 * @since 2020-04-26
 */
@RestControllerEndpoint(
        id = "springCloudBus"
)
public class ApiEndpoint extends AbstractBusEndpoint {

    public ApiEndpoint(ApplicationEventPublisher context, String appId) {
        super(context, appId);
    }

    @PostMapping("/refresh")
    public void busRefreshWithDestination(@RequestParam(required = false) String destination) {
        this.publish(new MyRemoteApplicationEvent(this, this.getInstanceId(), destination));
    }
}
