package com.springboard.service;

import com.springboard.mapper.MemberMapper;
import com.springboard.vo.MemberVO;

import lombok.Setter;

public class MemberServiceImpl implements MemberService {

	@Setter
	private MemberMapper memberMapper;
	
	@Override
	public void registerMember(MemberVO member) {

		memberMapper.insertMember(member);
		
	}

	@Override
	public MemberVO findMemberByEmailAndPasswd(MemberVO member) {

		return memberMapper.selectMemberByEmailAndPasswd(member);
		
	}

}
