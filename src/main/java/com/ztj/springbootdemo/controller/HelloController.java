package com.ztj.springbootdemo.controller;

import com.ztj.springbootdemo.entity.AppProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private AppProperties appProperties;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/properties")
    public String properties() {
        return appProperties.getDesc() + " " + appProperties.getStrvalue() + " " + appProperties.getIntvalue();
    }

}
