package com.kx.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author kx
 * @date 2019/12/27 14:31
 */

/**
 * spring boot提供了一个Environment类，可以读取applicaiton.properties、
 * 命令行参数、系统参数、操作系统环境变量，等等，各种参数和配置。
 * 可以通过spring bean注入的方式获取到这个Environment，很多时候，
 * 可能并不想直接使用@Value将某些参数读取到系统里面来，
 * 但是你可以注入一个Environment，从这个里面去获取需要的一些参数
 */
@Configuration
public class EnvironmentConfig {

	@Autowired
	private Environment env;

	public int getServerPort() {
		return env.getProperty("server.port", Integer.class);
	}

}
