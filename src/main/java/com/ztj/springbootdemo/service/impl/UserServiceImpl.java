package com.ztj.springbootdemo.service.impl;

import com.ztj.springbootdemo.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }

}
