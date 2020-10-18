package com.example.demo.model;

/**
 * 描述：用户实体
 *
 * @author ay
 * @since 2020/10/8
 */
public class AyUser {

    //主键
    private Integer id;

    //姓名
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AyUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AyUser() {}
}
