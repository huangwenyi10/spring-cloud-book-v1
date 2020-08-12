package com.example.ayuserapi;

public class FeignClientFallback implements UserFeignApi {

    @Override
    public String getUserName() {
        return "sorry, error";
    }
}