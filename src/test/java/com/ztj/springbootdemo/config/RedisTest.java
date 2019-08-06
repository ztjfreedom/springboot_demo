package com.ztj.springbootdemo.config;

import com.ztj.springbootdemo.entity.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Cat> redisTemplate;

    @Test
    public void test() throws Exception {
        // store string
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // store object
        Cat cat = new Cat("cat1", 20);
        redisTemplate.opsForValue().set(cat.getName(), cat);
        cat = new Cat("cat2", 30);
        redisTemplate.opsForValue().set(cat.getName(), cat);
        cat = new Cat("cat3", 40);
        redisTemplate.opsForValue().set(cat.getName(), cat);
        Assert.assertEquals(20, redisTemplate.opsForValue().get("cat1").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("cat2").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("cat3").getAge().longValue());
    }

}
