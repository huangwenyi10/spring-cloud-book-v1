package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author ay
 * @since 2020-06-27
 */
@RestController
public class UserController {
    @GetMapping("/user/{id}")
    public String getUser(@PathParam("id") Integer id){
        return "ay:" + id;
    }

    @GetMapping("/user2/getUser")
    public String getUser2(){
        return "ay";
    }
}

