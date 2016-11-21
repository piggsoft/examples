package com.piggsoft;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringValidationExampleApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void test01() throws Exception {
		mockMvc.perform(get("/home/get?id=100")).andExpect(status().isOk())
				.andExpect(jsonPath("$.code", is(1102)))
				.andDo(print());
	}

	@Test
	public void test02() throws Exception {
		mockMvc.perform(get("/home/get?id=1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.code", is(1103)))
				.andDo(print());
	}

	@Test
	public void test03() throws Exception {
		mockMvc.perform(get("/home/get?id=1&username=aa")).andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void test04() throws Exception {
		mockMvc.perform(get("/home/get?id=1&username=a&password=a s")).andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void test5() throws Exception {
		mockMvc.perform(get("/home/get?id=1&username=a&password=as")).andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void test06() throws Exception {
		mockMvc.perform(get("/home/get?id=1&username=a&password=as&address=aa")).andExpect(status().isOk())
				.andDo(print());
	}



}
