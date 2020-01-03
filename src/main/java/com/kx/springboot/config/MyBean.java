package com.kx.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kx
 * @date 2019/12/27 14:08
 */
@Component
public class MyBean {

	// 用@Value注解就可以将外部配置注入到类中来
	// 对配置项的名称用${}形式来表达
	@Value("${my.hello}")
	private String hello;



}
