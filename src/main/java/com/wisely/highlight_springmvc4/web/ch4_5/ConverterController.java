package com.wisely.highlight_springmvc4.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisely.highlight_springmvc4.domain.DemoObj;

@Controller
public class ConverterController {
	
	//指定返回的媒体类型为我们自定义的媒体类型
	@RequestMapping(value="/convert",produces={"application/x-wisely"})
	@ResponseBody
	public DemoObj convert(@RequestBody DemoObj demoObj){
		return demoObj;
	}
	
	
}
