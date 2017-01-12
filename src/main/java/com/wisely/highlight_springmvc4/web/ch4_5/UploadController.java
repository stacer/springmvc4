package com.wisely.highlight_springmvc4.web.ch4_5;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@ResponseBody
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(MultipartFile file,HttpServletRequest request){
		try {
			FileUtils.writeByteArrayToFile(new File("e:/upload/"+file.getOriginalFilename()),file.getBytes());
			return "ok";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "wrong";
		}
	}
}
