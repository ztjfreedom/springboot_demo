package com.ztj.springbootdemo.controller;

import com.ztj.springbootdemo.entity.LocalDateUser;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="/localdateusers")
@ApiIgnore
public class LocalDateUserController {

    /**
     * @param localDateUser  RequestBody here means receive json formatted parameters
     * @return
     */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public LocalDateUser postUser(@RequestBody LocalDateUser localDateUser) {
        return localDateUser;
    }

}
