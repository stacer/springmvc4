package com.wisely.highlight_springmvc4.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInteceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("本次处理请求的时间为"+new Long(endTime-startTime)+"ms");
		request.setAttribute("handlingTime", endTime-startTime);
	}
}
