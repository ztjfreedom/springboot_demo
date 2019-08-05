package com.ztj.springbootdemo.service;

public interface UserService {

    /**
     * create a user
     */
    void create(String name, Integer age);

    /**
     * delete user by name
     */
    void deleteByName(String name);

    /**
     * get user number
     */
    Integer getAllUsers();

    /**
     * delete all users
     */
    void deleteAllUsers();

}
