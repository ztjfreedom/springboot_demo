package com.ztj.springbootdemo.entity;

import com.ztj.springbootdemo.properties.AppProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppPropertiesTest {

    @Resource
    private AppProperties appProperties;

    @Test
    public void testAppProperties() {
        Assert.assertEquals(appProperties.getAuthor(), "brebro");
        Assert.assertEquals(appProperties.getTitle(), "demo");
        Assert.assertNotNull(appProperties.getStrvalue());
        Assert.assertTrue(appProperties.getIntvalue() >= 10 && appProperties.getIntvalue() <= 20);
    }

}
