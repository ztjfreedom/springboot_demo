package com.ztj.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class LocalDateUser {

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
