package com.springboard.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private int rno;
	private int bno;
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
	private boolean deleted;
	
	// 댓글의 논리적인 순서를 관리하기 위한 변수들
	private int gno;	// group no
	private int sno;	// step no (그룹내 순서 번호)
	private int depth;	// 들여쓰기
	
}









