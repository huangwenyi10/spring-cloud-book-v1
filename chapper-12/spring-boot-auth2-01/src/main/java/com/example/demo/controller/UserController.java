package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ay
 * @since 2020-10-18
 */
@Controller
public class UserController {
    @RequestMapping("/api/user")
    public ResponseEntity<UserDO> getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername() + "@163.com";
        UserDO userDO = new UserDO();
        userDO.setName(user.getUsername());
        userDO.setEmail(email);
        return ResponseEntity.ok(userDO);
    }
}

