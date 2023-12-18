package com.kot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kot.model.dto.Reply;
import com.kot.model.service.ReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board")
@Api(tags = "reply controller")
public class ReplyRestController {

	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/{boardId}")
	@ApiOperation(value = "해당 게시글 모든 댓글 조회")
	public ResponseEntity<?> allReply(@PathVariable int boardId) {
		List<Reply> list = replyService.allReply(boardId);
		return new ResponseEntity<List<Reply>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "댓글 작성")
	public ResponseEntity<?> writeReply(@RequestBody Reply reply) {
		int result = replyService.writeReply(reply);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	@ApiOperation(value = "댓글 수정")
	public ResponseEntity<?> updateReply(@RequestBody Reply reply) {
		replyService.updateReply(reply);
		return new ResponseEntity<Reply>(reply, HttpStatus.CREATED);
	}

	@PutMapping("/delete")
	@ApiOperation(value = "댓글 삭제")
	public ResponseEntity<?> deleteReply(@RequestBody Reply reply) {
		replyService.deleteReply(reply);
		return new ResponseEntity<Reply>(reply, HttpStatus.CREATED);
	}
	
}