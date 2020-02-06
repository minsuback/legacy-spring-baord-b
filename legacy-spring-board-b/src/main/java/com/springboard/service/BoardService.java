package com.springboard.service;

import java.util.HashMap;
import java.util.List;

import com.springboard.vo.BoardVO;

public interface BoardService {

	int writeBoard(BoardVO board);
	List<BoardVO> findBoard();
	List<BoardVO> findBoardWithPaging(HashMap<String, Object> params);
	BoardVO findBoardByBno(int bno);
	void deleteBoard(int bno);
	void updateBoard(BoardVO board);
	void increaseReadCount(int bno);
	int findBoardCount(HashMap<String, Object> params);
	
	
}
