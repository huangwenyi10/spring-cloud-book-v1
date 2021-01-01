package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CommonsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonsApplication.class, args);
    }

    @Value("${myrandom}")
    private String myrandom;

    @Value("${myrandom2}")
    private String myrandom2;

    @Value("${keySecond}")
    private String keySecond;

    @GetMapping("/get")
    public void get(){
        System.out.println(myrandom);
        System.out.println(myrandom2);

        System.out.println(keySecond);
    }

    public String getMyrandom() {
        return myrandom;
    }

    public void setMyrandom(String myrandom) {
        this.myrandom = myrandom;
    }
}
