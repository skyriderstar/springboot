package com.kx.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author kx
 * @date 2019/12/27 14:48
 */

/**
 * 一次性将一组配置属性读取到一个配置管理中去
 */
@ConfigurationProperties("spring.datasource")
@Configuration
public class ConfigProperties {

	/**
	 * 保持与配置文件名称相同即可获得取值
	 */
	private int initialSize;

	private int minIdle;

}
