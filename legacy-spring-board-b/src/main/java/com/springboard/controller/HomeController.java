package com.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // @Component + spring mvc 기능 추가
public class HomeController {
	
	//@RequestMapping : 요청과 메서드를 매핑
	@RequestMapping(path = { "/" }, method = RequestMethod.GET)
	public String home() {
		
		return "home"; // viewname -> /WEB-INF/views/ + home + .jsp
	}
	
}
