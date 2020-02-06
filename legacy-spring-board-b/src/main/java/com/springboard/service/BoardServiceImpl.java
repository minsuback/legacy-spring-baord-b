package com.springboard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.springboard.mapper.BoardMapper;
import com.springboard.repository.BoardDao;
import com.springboard.vo.BoardVO;

import lombok.Setter;

public class BoardServiceImpl implements BoardService {
	
	// setter 메서드 이용한 의존성 주입 (root-context.xml -> property)
	@Setter // lombok 이 setter 메서드 만드는 어노테이션
	private BoardDao boardDao;
	
	@Setter
	private BoardMapper boardMapper;
	
	@Setter
	private PlatformTransactionManager txManager; 
	
	@Setter
	private TransactionTemplate txTemplate;
	
	@Override
	public int writeBoard(BoardVO board) {
				
		// TransactionTemplate 사용해서 트랜잭션 관리
//		txTemplate.execute(new TransactionCallback<Void>() {
//
//			@Override
//			public Void doInTransaction(TransactionStatus status) {
//				try {
//					boardMapper.insertBoard(board);
//					if (Math.random() < 0.5) {
//						int x = 10 / 0;
//					}
//					System.out.println("트랜잭션 완료");
//				} catch (Exception ex) {
//					System.out.println("트랜잭션 취소");
//					status.setRollbackOnly(); //트랙잭션 취소
//				}
//				return null;
//			}
//		});
		
		// PlatformTrascationManager 사용해서 트랜잭션 관리
		TransactionStatus status = 
			txManager.getTransaction(new DefaultTransactionDefinition());

		try {
			boardMapper.insertBoard(board);
			if (Math.random() < 0.5) {
				int x = 10 / 0;
			}
			System.out.println("트랜잭션 완료");
			txManager.commit(status);
		} catch (Exception ex) {
			System.out.println("트랜잭션 취소");
			txManager.rollback(status);
		}
		
		return board.getBno();
		
	}

	@Override
	public List<BoardVO> findBoard() {

		//return boardDao.selectBoard();
		return boardMapper.selectBoard();
		
	}
	
	@Override
	public List<BoardVO> findBoardWithPaging(HashMap<String, Object> params) {
		
		return boardMapper.selectBoardWithPaging(params);
		
	}


	@Override
	public BoardVO findBoardByBno(int bno) {
		
		return boardMapper.selectBoardByBno(bno);
		
	}

	@Override
	public void deleteBoard(int bno) {

		boardMapper.deleteBoard(bno);
		if (Math.random() < 0.5) {	//트랜잭션 테스트를 위한 코드
			int x = 10 / 0;
		}
		
	}

	@Override
	public void updateBoard(BoardVO board) {
		
		boardMapper.updateBoard(board);
		
	}

	@Override
	public void increaseReadCount(int bno) {
		
		boardMapper.updateReadCount(bno);
		
	}

	@Override
	public int findBoardCount(HashMap<String, Object> params) {

		return boardMapper.selectBoardCount(params);

	}
	
}














