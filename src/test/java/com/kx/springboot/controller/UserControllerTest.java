package com.kx.springboot.controller;

/**
 * @author kx
 * @date 2019/12/30 11:42
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kx.springboot.domain.User;
import com.kx.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * 用户管理模块的控制器组件的单元测试类
 */
@RunWith(SpringRunner.class)
/*
 * 通过这个注解表明，你要测试的controller是谁
 */
@WebMvcTest(UserController.class)
public class UserControllerTest {

	/**
	 * 注入一个 MockMvc , 模拟对controller 发起 HTTP 请求
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * 模拟 userService 组件
	 */
	@MockBean
	private UserService userService;


	/**
	 * 测试用例, 查询所有用户信息
	 */
	@Test
	public void testListUsers() {
		try {
			List<User> users = new ArrayList<User>();
			List<User> users1 = new ArrayList<User>();

			User user = new User();
			user.setId(1L);
			user.setName("test");
			user.setAge(20);

			User user1 = new User();
			user1.setId(2L);
			user1.setName("test1");
			user1.setAge(30);

			users.add(user);
			users1.add(user1);

			when(userService.listUsers()).thenReturn(users);

			mockMvc.perform(get("/user/")).andExpect(content().json(JSONArray.toJSONString(users)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试用例 : 根据ID查找一个用户
	 */
	@Test
	public void testGetUserById() {
		try {
			Long userId = 1L;

			User user = new User();
			user.setId(userId);
			user.setName("kx");
			user.setAge(18);

			User user1 = new User();
			user1.setId(userId);
			user1.setName("haha");
			user1.setAge(18);

			when(userService.getUserById(userId)).thenReturn(user);

			mockMvc.perform(get("/user/{id}", userId)).andExpect(content().json(JSONObject.toJSONString(user)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 测试用例 : 新增用户
	 */
	@Test
	public void testSaveUser() {
		Long userId = 2L;

		User user = new User();
		user.setName("test");
		user.setAge(22);

		when(userService.saveUser(user)).thenReturn(userId);

		try {
			mockMvc.perform(post("/user/").contentType("application/json").content(JSONObject.toJSONString(user)))
					.andExpect(content().json("{'status': 'success', 'message': '新增用户ID为" + userId + "'}"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
