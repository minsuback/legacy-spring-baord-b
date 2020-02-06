package com.example.springmvc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springboard.service.BoardService;
import com.springboard.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j // Log4j 객체를 자동으로 만드는 annotation (변수이름 : log)
public class DemoTest2 {
	
	//Controller, Service, Dao or Mapper 테스트 코드
	
	private MockMvc mockMvc; // 브라우저를 대신하는 모형
	
	@Autowired
	private WebApplicationContext ctx;
	
	@Before // @Test로 지정된 메서드를 호출하기 전에 실행
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testOne() throws Exception {
		
		mockMvc.perform(post("/account/login.action")
							.param("email", "iamuserone@example.com")
							.param("passwd", "9922"))
			   .andExpect(status().is3xxRedirection())
			   //.andExpect(status().is2xxSuccessful())
			   .andDo(print());
		
	}

}








