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

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalDateUserControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new LocalDateUserController()).build();
    }

    @Test
    public void test() throws Exception {
        RequestBuilder request;

        // post to add a user
        request = post("/localdateusers/").
                contentType("application/json").
                content("{\"name\":\"master\", \"birthday\":\"1987-01-01\"}");

        mockMvc.perform(request)
                .andExpect(content().string(equalTo("{\"name\":\"master\",\"birthday\":\"1987-01-01\"}")));
    }

}
