package com.ztj.springbootdemo.controller;

import com.ztj.springbootdemo.entity.User;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * Design of a restful API
 * type:           url:              function:
 * GET             /users            get user list
 * POST            /users            create a user
 * GET             /users/id         get a user
 * PUT             /users/id         update a user
 * DELETE          /users/id         delete a user
 */
@RestController
@RequestMapping(value="/users")
@ApiIgnore
public class UserController {

    // multi-thread safe
    private static Map<Long, User> usersMap = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUserList() {
        // GET request, get all users
        // We can use @RequestParam to get parameters
        return new ArrayList<>(usersMap.values());
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        // POST request, create a user
        // @ModelAttribute is used to bind parameters, we can also use @RequestParam to get parameters
        usersMap.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // GET request, get a user whose id is in the url /users/{id}
        // @PathVariable is used to get parameters from url
        return usersMap.get(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // PUT request, update a user
        User u = usersMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        usersMap.put(id, u);
        return "success";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // DELETE request, delete a user
        usersMap.remove(id);
        return "success";
    }

}
