/* Refer to document: https://github.com/alibaba/nacos/blob/master/example/src/main/java/com/alibaba/nacos/example
*  pom.xml
    <dependency>
        <groupId>com.alibaba.nacos</groupId>
        <artifactId>nacos-client</artifactId>
        <version>${latest.version}</version>
    </dependency>
*/
package com.example.demo;

import java.io.IOException;
import java.util.Properties;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

/**
 * @author nkorange
 */
public class NamingExample {

    public static void main(String[] args) throws NacosException {

        Properties properties = new Properties();
        String serverAddr = "192.168.49.79";
        properties.setProperty("serverAddr", serverAddr);
        String namespace = "public";
        properties.setProperty("namespace", namespace);

        NamingService naming = NamingFactory.createNamingService(properties);

        naming.registerInstance("service-consumer", "1.1.1.1", 8888, "TEST1");

        naming.registerInstance("service-consumer", "2.2.2.2", 9999, "DEFAULT");

        System.out.println(naming.getAllInstances("service-consumer"));

        naming.deregisterInstance("service-consumer", "2.2.2.2", 9999, "DEFAULT");

        System.out.println(naming.getAllInstances("service-consumer"));

        naming.subscribe("service-consumer", new EventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println(((NamingEvent) event).getServiceName());
                System.out.println(((NamingEvent) event).getInstances());
            }
        });
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}