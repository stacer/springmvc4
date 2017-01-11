package com.wisely.highlight_springmvc4.web.ch4_3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisely.highlight_springmvc4.domain.DemoObj;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
	
	//未标明路径,使用类级别路径
	@RequestMapping(produces="text/plain;charset=utf-8")
	@ResponseBody
	public String index(HttpServletRequest request){
		return "url:" + request.getRequestURL()+ "can access";
	}
	
	@RequestMapping(value="/pathvar/{str}",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String demoPathVar(@PathVariable String str,HttpServletRequest request){
		return "url:" + request.getRequestURL() + "can access,str:"+str;
	}
	
	@RequestMapping(value="/requestParam",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String passRequestParam(Long id,HttpServletRequest request){
		return "url:" + request.getRequestURL()+"can access,id" + id;
	}
	
	@RequestMapping(value="/obj",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String passObj(DemoObj obj,HttpServletRequest request){
		return "url:"+request.getRequestURL()+"can access,Obj id:"+obj.getId()+
				"obj name:"+obj.getName();
	}
	
	@RequestMapping(value = {"/name1","/name2"},produces="text/plain;charset=utf-8" )
	public String remove(HttpServletRequest request){
		return "url:" + request.getRequestURL() + "can access";
	}
}
