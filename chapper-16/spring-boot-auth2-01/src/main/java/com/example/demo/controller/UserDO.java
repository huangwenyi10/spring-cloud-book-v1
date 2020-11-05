package com.example.demo.controller;

/**
 * 描述：用户信息
 *
 * @author ay
 * @since 2020-04-21
 */
public class UserDO {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDO [name=" + name + ", email=" + email + "]";
    }
}