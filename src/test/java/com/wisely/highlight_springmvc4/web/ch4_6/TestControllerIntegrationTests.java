package com.wisely.highlight_springmvc4.web.ch4_6;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wisely.highlight_springmvc4.MyMvcConfig;
import com.wisely.highlight_springmvc4.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
/**
 * <p>
 * 	@WebAppConfiguration注解在类上,用来声明加载的ApplicationContext
 * 是一个WebApplicationContext.它的属性指定的是WEB资源的位置,默认为src/main/webapp
 * 本例修改为src/main/resources
 * </p>
 * @author 326873
 *
 */
@WebAppConfiguration("src/main/resources")
@ContextConfiguration(classes={MyMvcConfig.class})
public class TestControllerIntegrationTests {
	/**
	 * MockMvc-模拟MVC对象,通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化
	 */
	private MockMvc mockMvc;
	
	/**
	 * 在测试用例中注入Spring的Bean
	 */
	@Autowired
	private DemoService demoService;
	
	/**
	 * 注入WebApplicationContext
	 */
	@Autowired
	WebApplicationContext wac;
	
	/**
	 * 注入模拟的http session
	 */
	@Autowired
	MockHttpSession session;
	
	/**
	 * 注入模拟的http request
	 */
	@Autowired
	MockHttpServletRequest request;
	
	/**
	 * 测试开始前进行初始化工作
	 */
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testNormalController() throws Exception{
		//模拟向/normal进行get请求
		mockMvc.perform(get("/normal"))
		//预期控制返回状态为200
		.andExpect(status().isOk())
		//预期view的名称为page
		.andExpect(view().name("page"))
		//预期页面转向的真正路径为/WEB-INF/classes/views/page.jsp
		.andExpect(forwardedUrl("WEB-INF/classes/views/page.jsp"))
		.andExpect(model().attribute("msg", demoService.saySomething()));
	}
	
	@Test
	public void testRestController() throws Exception{
		//模拟向/testRest进行get请求
		mockMvc.perform(get("/testRest"))
		.andExpect(status().isOk())
		//预期返回值的媒体类型为text/plain;charset=utf-8
		.andExpect(content().contentType("text/plain;charset=utf-8"))
		//预期返回值的内容为demoService.saySomething()的返回值hello
		.andExpect(content().string(demoService.saySomething()));
	}
}
