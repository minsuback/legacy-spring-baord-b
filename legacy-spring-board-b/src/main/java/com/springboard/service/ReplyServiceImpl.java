package com.springboard.service;

import java.util.List;

import com.springboard.mapper.ReplyMapper;
import com.springboard.vo.ReplyVO;

import lombok.Setter;

public class ReplyServiceImpl implements ReplyService {

	@Setter
	private ReplyMapper replyMapper;
	
	@Override
	public void writeReply(ReplyVO reply) {
		
		replyMapper.insertReply(reply);
		
	}

	@Override
	public List<ReplyVO> getReplyListByBno(int bno) {
		
		return replyMapper.selectRepliesByBno(bno);
	}

	@Override
	public void deleteReply(int rno) {
		
		replyMapper.deleteReply(rno);
		
	}

	@Override
	public void updateReply(ReplyVO reply) {
		
		replyMapper.updateReply(reply);
		
	}

	@Override
	public void writeReReply(ReplyVO reply) {
		
		ReplyVO parent = replyMapper.selectReplyByRno(reply.getRno());
		reply.setGno(parent.getGno());
		reply.setSno(parent.getSno() + 1);
		reply.setDepth(parent.getDepth() + 1);
		
		replyMapper.updateSno(parent);

		replyMapper.insertReply2(reply);
		
	}

}















