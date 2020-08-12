package com.example.demo;
import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.niws.client.http.RestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(DemoApplication.class, args);
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        HttpRequest request = HttpRequest.newBuilder().uri("/user/getName").build();
        for(int i = 0; i < 10; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            String result = response.getEntity(String.class);
            System.out.println(result);
        }
    }
}
