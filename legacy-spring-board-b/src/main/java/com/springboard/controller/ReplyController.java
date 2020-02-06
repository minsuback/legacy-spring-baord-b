package com.springboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboard.service.ReplyService;
import com.springboard.vo.ReplyVO;

//@RestController // @Controller + 모든 요청 메서드에 @ResponseBody
@Controller
@RequestMapping(path= { "/reply" })
public class ReplyController {
	
	@Autowired
	@Qualifier("replyService")
	private ReplyService replyService;
	
	@PostMapping("/write")
	@ResponseBody
	public String write(ReplyVO reply, String action) {
		
		//reply.getRno() -> 0
		if (action.equals("reply")) {
			replyService.writeReply(reply);
		} else if (action.equals("re-reply")) {
			replyService.writeReReply(reply);
		}
		//reply.getRno() -> 새로 등록된 Reply 번호
		
		return "success"; // + " : " + reply.getRno();
	}
	
	@GetMapping(path = { "/list-by/{bno}" })
	public String listByBno(@PathVariable int bno, Model model) {
		
		List<ReplyVO> replies = replyService.getReplyListByBno(bno);
		
		model.addAttribute("replies", replies);
		
		return "board/reply-list";
	}
	
	@DeleteMapping(path = { "/delete/{rno}" }) // path string의 {} -> 데이터
	@ResponseBody
	public String delete(@PathVariable int rno) {
		
		replyService.deleteReply(rno);
		
		return "success";
	}
	
	@PutMapping(path = { "/update" }, consumes = "application/json")
	@ResponseBody
	public String update(@RequestBody ReplyVO reply) { //@RequestBody : 요청 본문을 직접 읽어서 객체 매핑
		
		replyService.updateReply(reply);
		
		return "successs";
	}

}













