package com.springboard.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.springboard.mapper.BoardMapper;
import com.springboard.vo.BoardVO;

import lombok.Setter;

public class MyBatisMapperBoardDao implements BoardDao {
	
	@Setter
	private BoardMapper boardMapper;
	
	@Override
	public int insertBoard(BoardVO board) {
		
		//board.getBno() -> 0 (비어 있는 데이터)
		
		boardMapper.insertBoard(board);
		
		return board.getBno(); // -> 새로 등록된 글 번호
		
	}

	@Override
	public List<BoardVO> selectBoard() {

		List<BoardVO> boards = boardMapper.selectBoard();
		
		return boards;
		
	}
}
















