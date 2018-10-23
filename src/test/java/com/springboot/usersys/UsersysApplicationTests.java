package com.springboot.usersys;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UsersysApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void addTest() throws Exception{
		String requestParam = "{\n" +
				"  \"delStatus\": 0,\n" +
				"  \"pwd\": \"123456\",\n" +
				"  \"userAccount\": \"王曦\"\n" +
				"}";
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/addUser")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(requestParam);
		MvcResult result = mockMvc.perform(requestBuilder)
							.andExpect(MockMvcResultMatchers.status().isOk())
							.andReturn();
		System.out.println(result.getResponse().getContentAsString());

	}

	@Test
	public void UserList() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/getUsers"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void delUser() throws  Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/delUser").param("Id","44"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void updateUser() throws Exception {
		MvcResult result  = mockMvc.perform(MockMvcRequestBuilders.post("/user/updateUser")
				.param("Id","44")
				.param("pwd","888"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

//	@Test
//	public void contextLoads() {
//	}

}
