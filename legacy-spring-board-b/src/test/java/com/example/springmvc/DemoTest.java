package com.example.springmvc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboard.service.BoardService;
import com.springboard.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j // Log4j 객체를 자동으로 만드는 annotation (변수이름 : log)
public class DemoTest {
	
	//Controller, Service, Dao or Mapper 테스트 코드
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	@Test
	public void testOne() {
		
		List<BoardVO> boards = boardService.findBoard();
		
		assertNotNull(boards);
		
		assertTrue(boards.size() > 0);
		
	}

}








