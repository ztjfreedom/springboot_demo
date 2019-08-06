package com.ztj.springbootdemo.service;

import com.ztj.springbootdemo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    @Rollback
    public void testUserMapper() {
        userMapper.insert("AAA", 20);
        User user = userMapper.findByName("AAA");
        Assert.assertEquals(20, user.getAge().intValue());

        user.setAge(30);
        userMapper.update(user);
        user = userMapper.findByName("AAA");
        Assert.assertEquals(30, user.getAge().intValue());

        userMapper.delete(user.getId());
        user = userMapper.findByName("AAA");
        Assert.assertNull(user);

        user = new User("BBB", 30);
        userMapper.insertByUser(user);
        Assert.assertEquals(30, userMapper.findByName("BBB").getAge().intValue());

        Map<String, Object> map = new HashMap<>();
        map.put("name", "CCC");
        map.put("age", 40);
        userMapper.insertByMap(map);
        Assert.assertEquals(40, userMapper.findByName("CCC").getAge().intValue());

        List<User> userList = userMapper.findAll();
        for (User u : userList) {
            Assert.assertNull(u.getId());
            Assert.assertNotNull(u.getName());
        }
    }

}
