package com.ztj.springbootdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void test() throws Exception {
        RequestBuilder request;

        // 1. get user list, empty at first
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // 2. post to add a user
        request = post("/users/")
                .param("id", "1")
                .param("name", "master")
                .param("age", "20");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3. get user list
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"master\",\"age\":20}]")));

        // 4. put to update the user
        request = put("/users/1")
                .param("name", "super master")
                .param("age", "30");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5. get a user with id 1
        request = get("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"super master\",\"age\":30}")));

        // 6. delete a user with id 1
        request = delete("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7. get user list, empty at last
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

}
