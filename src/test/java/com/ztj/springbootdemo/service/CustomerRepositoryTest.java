package com.ztj.springbootdemo.service;

import com.ztj.springbootdemo.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Resource
    private CustomerRepository customerRepository;

    @Test
    public void testCustomerRepository() {
        customerRepository.save(new Customer("AAA", 10));
        customerRepository.save(new Customer("BBB", 20));
        customerRepository.save(new Customer("CCC", 30));
        customerRepository.save(new Customer("DDD", 40));
        customerRepository.save(new Customer("EEE", 50));
        customerRepository.save(new Customer("FFF", 60));
        customerRepository.save(new Customer("GGG", 70));
        customerRepository.save(new Customer("HHH", 80));
        customerRepository.save(new Customer("III", 90));
        customerRepository.save(new Customer("JJJ", 100));
        Assert.assertEquals(10, customerRepository.findAll().size());
        Assert.assertEquals(60, customerRepository.findByName("FFF").getAge().longValue());
        Assert.assertEquals(60, customerRepository.findUser("FFF").getAge().longValue());
        Assert.assertEquals("FFF", customerRepository.findByNameAndAge("FFF", 60).getName());
        customerRepository.delete(customerRepository.findByName("AAA"));
        Assert.assertEquals(9, customerRepository.findAll().size());
    }

}
