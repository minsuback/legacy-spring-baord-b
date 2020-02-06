package com.springboard.service;

import java.util.List;

import com.springboard.vo.ReplyVO;

public interface ReplyService {
	
	void writeReply(ReplyVO reply);

	List<ReplyVO> getReplyListByBno(int bno);

	void deleteReply(int rno);

	void updateReply(ReplyVO reply);

	void writeReReply(ReplyVO reply);

}
