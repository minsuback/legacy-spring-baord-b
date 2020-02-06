package com.springboard.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.springboard.vo.BoardVO;

import lombok.Setter;

public class MyBatisBoardDao implements BoardDao {
	
	private final String MAPPER = "com.springboard.mapper.BoardMapper."; 
	
	@Setter
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public int insertBoard(BoardVO board) {
		
		//board.getBno() -> 0 (비어 있는 데이터)
		sessionTemplate.insert(
			//"com.springboard.mapper.BoardMapper.insertBoard", board);
			MAPPER + "insertBoard", board);
		
		return board.getBno(); // -> 새로 등록된 글 번호
		
	}

	@Override
	public List<BoardVO> selectBoard() {

		List<BoardVO> boards = sessionTemplate.selectList(
			//"com.springboard.mapper.BoardMapper.selectBoard");
			MAPPER + "selectBoard");
		
		return boards;
		
	}
}
















