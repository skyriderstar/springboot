package com.kx.springboot.mvcconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author kx
 * @date 2019/12/27 11:05
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
	@Override
	public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

	}

	// 格式化
	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
		formatterRegistry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/user/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

	}

	// 跨域访问配置
	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/user/**").allowedOrigins("*").allowedMethods("*");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
		viewControllerRegistry.addViewController("/addUserUI").setViewName("/addUser.jsp");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

	}

	@Override
	public Validator getValidator() {
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		return null;
	}
}
