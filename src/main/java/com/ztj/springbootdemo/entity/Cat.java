package com.ztj.springbootdemo.entity;

import java.io.Serializable;

public class Cat implements Serializable {

    private static final long serialVersionUID = -1L;

    private String name;
    private Integer age;

    public Cat(String username, Integer age) {
        this.name = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
