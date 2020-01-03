package com.kx.springboot.controller;

import com.kx.springboot.domain.User;
import com.kx.springboot.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kx
 * @date 2019/12/26 11:28
 */
@RestController
@RequestMapping("/user")
public class UserController {
	Log log = LogFactory.getLog(UserController.class);

	/**
	 * 用户管理模块的service组件
	 */
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> listUser() {
		return userService.listUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

	@PostMapping("/")
	public String saveUser(@Validated({User.Add.class}) @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			FieldError error = (FieldError) errors.get(0);
			System.out.println(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
			return "error";
		}
		System.out.println("user: " + user);
		Long userId = userService.saveUser(user);
		System.out.println("userService.saveUser: " + userId);
		log.info("我的天, 这是一个test");
		return "{'status': 'success', 'message': '新增用户ID为" + userId + "'}";
	}

	@PutMapping("/{id}")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") Long id) {
		userService.removeUser(id);
	}


}
