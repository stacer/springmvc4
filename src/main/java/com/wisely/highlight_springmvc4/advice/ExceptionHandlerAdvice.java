package com.wisely.highlight_springmvc4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice  //声明一个控制器建言,@ControllerAdvice组合了@Component注解
public class ExceptionHandlerAdvice {
	
	//@ExceptionHandler定义全局处理,通过@ExceptionHandler的value属性可过滤拦截条件
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception(Exception exception,WebRequest request){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMessage",exception.getMessage());
		return modelAndView;
	}
	
	//使用@ModelAttribute注解将键值对添加到全局,所有注解的@RequestMapping的方法可获得此键值对
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("msg", "额外信息");
	}
	
	@InitBinder//定制WebDataBinder
	public void initBinder(WebDataBinder webDataBinder){
		//忽略request参数的id
		webDataBinder.setDisallowedFields("id");
	}
}
