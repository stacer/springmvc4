package com.wisely.highlight_springmvc4.web.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.highlight_springmvc4.domain.DemoObj;

@RequestMapping("/rest")
@RestController
public class DemoRestController {
	
	@RequestMapping(value="/getJson",produces={"application/json;charset=utf-8"})
	public DemoObj getJson(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
	
	@RequestMapping(value="/getXml",produces={"application/xml;charset=utf-8"})
	public DemoObj getXml(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
	
}
