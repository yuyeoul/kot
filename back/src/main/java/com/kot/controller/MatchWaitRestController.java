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

import com.kot.model.dto.MatchWait;
import com.kot.model.service.MatchWaitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/matchwait")
@Api(tags = "신청 대기 컨트롤러")
public class MatchWaitRestController {
	
	@Autowired
	private MatchWaitService matchWaitService;
	
	@PostMapping("/send")
	@ApiOperation(value = "매칭 신청 보내기")
	public ResponseEntity<?> sendWait(@RequestBody MatchWait wait) {
		int result = matchWaitService.sendWait(wait);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/accept")
	@ApiOperation(value = "신청 수락하기(match=true로 만들기)")
	public ResponseEntity<?> acceptWait(@RequestBody MatchWait wait) {
		matchWaitService.acceptWait(wait);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/deleteAll")
	@ApiOperation(value = "남아있는 매칭 모두 삭제")
	public ResponseEntity<?> deleteAllWait(@RequestBody MatchWait wait) {
		matchWaitService.deleteAllWait(wait);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/start")
	@ApiOperation(value = "매칭 시작(user_status=true로 만들기)")
	public ResponseEntity<?> startMatch(@RequestBody MatchWait wait) {
		matchWaitService.startMatch(wait);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/delete")
	@ApiOperation(value = "받은 매칭 거절하기 / 신청한 매칭 취소하기")
	public ResponseEntity<?> deleteWait(@RequestBody MatchWait wait) {
		matchWaitService.deleteWait(wait);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/received/{receiver}")
	@ApiOperation(value = "받은 신청 목록")
	public ResponseEntity<?> receivedWait(@PathVariable String receiver) {
		List<MatchWait> list = matchWaitService.receivedWait(receiver);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MatchWait>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/sent/{sender}")
	@ApiOperation(value = "보낸 신청 목록")
	public ResponseEntity<?> sentWait(@PathVariable String sender) {
		List<MatchWait> list = matchWaitService.sentWait(sender);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MatchWait>>(list, HttpStatus.OK);
	}
}
