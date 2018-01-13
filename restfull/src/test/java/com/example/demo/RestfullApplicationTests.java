package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfullApplicationTests {
    private MockMvc mvc;
    @Before
	public void before(){
    	this.mvc= MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}
	@Test
	public void contextLoads() throws Exception {
		RequestBuilder req=get("/index");
		mvc.perform(req).andExpect(status().isOk()).andExpect(content().string("hello world"));
	}

}
