package com.example.demo.model;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/9/13
 */
public class User implements Serializable {

    private String username;
    private Long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
