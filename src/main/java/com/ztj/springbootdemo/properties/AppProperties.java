package com.ztj.springbootdemo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${com.ztj.app.author}")
    private String author;

    @Value("${com.ztj.app.title}")
    private String title;

    @Value("${com.ztj.app.desc}")
    private String desc;

    @Value("${com.ztj.randomvalue.strvalue}")
    private String strvalue;

    @Value("${com.ztj.randomvalue.intvalue}")
    private Integer intvalue;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStrvalue() {
        return strvalue;
    }

    public void setStrvalue(String strvalue) {
        this.strvalue = strvalue;
    }

    public Integer getIntvalue() {
        return intvalue;
    }

    public void setIntvalue(Integer intvalue) {
        this.intvalue = intvalue;
    }

}
