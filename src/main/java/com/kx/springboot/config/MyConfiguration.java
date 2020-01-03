package com.kx.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @author kx
 * @date 2019/12/27 14:22
 */

/**
 * @Profile({...})表明一个组件在一个或多个特定profile处于活跃状态时是可以注册的
 * spring.profiles.active=dev,hsqldb
 */
@Configuration
public class MyConfiguration {

	@Bean("dataSource")
	/**
	 * 在生产环境下生效
	 */
	@Profile("prod")
	public DataSource prodDatabase() {
		// 生产环境 bean 生成操作
		return null;
	}


	@Bean("dataSource")
	/**
	 * 在开发环境下生效
	 */
	@Profile("dev")
	public DataSource devDatabase() {
		return null;
	}

}
