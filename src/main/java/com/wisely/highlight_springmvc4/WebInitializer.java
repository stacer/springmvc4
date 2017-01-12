package com.wisely.highlight_springmvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplicationInitializer是Spring提供用来配置Servlet3.0+配置的接口
 * 从而实现了代替web.xml的位置。
 * 实现此接口将会自动被SpringServletContainerInitializer(用来启动servlet3.0容器)获取到
 * @author 326873
 *
 */
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyMvcConfig.class);
		//新建WebApplicationContext,注册配置类,并将其和当前servletContext关联
		ctx.setServletContext(servletContext);
		//注册SpringMVC的DispathcerServlet
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		//开启异步方法支持
		servlet.setAsyncSupported(true);
	}

}
