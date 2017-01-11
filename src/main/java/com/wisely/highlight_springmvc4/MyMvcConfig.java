package com.wisely.highlight_springmvc4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.wisely.highlight_springmvc4.inteceptor.DemoInteceptor;

@Configuration
@EnableWebMvc//开启Springmvc支持,若无此句,重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.wisely.highlight_springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 配置视图解析器
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		//addResourceLocations指的是文件放置的目录
		//addResourceHandler指的是对外暴露的访问路径
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	@Bean
	public DemoInteceptor demoInteceptor(){
		return new DemoInteceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInteceptor());
	}
}
