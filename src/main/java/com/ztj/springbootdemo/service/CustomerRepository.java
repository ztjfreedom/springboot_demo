package com.ztj.springbootdemo.service;

import com.ztj.springbootdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /*
    Query by method name
     */
    Customer findByName(String name);

    Customer findByNameAndAge(String name, Integer age);

    @Query("from Customer c where c.name=:name")
    Customer findUser(@Param("name") String name);

}
