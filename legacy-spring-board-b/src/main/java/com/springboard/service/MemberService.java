package com.springboard.service;

import com.springboard.vo.MemberVO;

public interface MemberService {

	void registerMember(MemberVO member);

	MemberVO findMemberByEmailAndPasswd(MemberVO member);

}
