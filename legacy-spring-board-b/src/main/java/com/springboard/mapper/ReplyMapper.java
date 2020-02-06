package com.springboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboard.vo.ReplyVO;

@Mapper // com/springboard/mapper/ReplyMapper.xml 파일을 찾아서 바인딩
		// root-context.xml 파일에 자동으로 bean 등록 (MapperFactoryBean 사용)
public interface ReplyMapper {
	
	void insertReply(ReplyVO reply);

	List<ReplyVO> selectRepliesByBno(int bno);

	void deleteReply(int rno);

	void updateReply(ReplyVO reply);

	void insertReply2(ReplyVO reply);
	
	ReplyVO selectReplyByRno(int rno);
	
	void updateSno(ReplyVO reply);

}
