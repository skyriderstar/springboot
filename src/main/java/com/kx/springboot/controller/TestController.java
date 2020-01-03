package com.kx.springboot.controller;

import com.kx.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author kx
 * @date 2019/12/26 14:11
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@GetMapping("/user/{id}")
	public User testGetUserById(@PathVariable("id") Long id) {
		RestTemplate client = restTemplateBuilder.build();
		String uri = "http://localhost:8080/user/{id}";
		return client.getForObject(uri, User.class, id);
	}

}
