package com.ztj.springbootdemo.controller;

import com.ztj.springbootdemo.exception.JsonException;
import com.ztj.springbootdemo.properties.AppProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
@ApiIgnore
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

    @RequestMapping("/hello_error")
    public String helloError() throws Exception {
        throw new Exception("man-made error");
    }

    @RequestMapping("/json_error")
    public String json() throws JsonException {
        throw new JsonException("man-made json error");
    }

}
