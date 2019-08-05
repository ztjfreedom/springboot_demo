package com.ztj.springbootdemo.controller;

import com.ztj.springbootdemo.properties.AppProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@Controller
@ApiIgnore
public class IndexController {

    @Resource
    private AppProperties appProperties;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // add an attribute
        map.addAttribute("author", appProperties.getAuthor());
        // direct to src/main/resources/templates/index.html
        return "index";
    }

}
