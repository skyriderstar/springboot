package com.kx.springboot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author kx
 * @date 2019/12/27 11:20
 */
public class CustomListener implements ApplicationListener<ApplicationStartingEvent> {
	@Override
	public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
		System.out.println("springboot 启动事件监听");
	}
}
