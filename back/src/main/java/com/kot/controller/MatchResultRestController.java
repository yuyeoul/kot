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

import com.kot.model.dto.MatchResult;
import com.kot.model.dto.MatchWait;
import com.kot.model.service.MatchResultService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/matchresult")
@Api(tags = "진행중 매치 컨트롤러")
public class MatchResultRestController {

	@Autowired
	private MatchResultService matchResultService;
	
	@PostMapping("/insert")
	@ApiOperation(value = "매칭 시작(matchResult에 insert)")
	public ResponseEntity<?> insertMatch(@RequestBody MatchResult result) {
		int rs = matchResultService.insertMatch(result);
		return new ResponseEntity<Integer>(rs, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	@ApiOperation(value = "현재 진행중인 매칭 불러오기")
	public ResponseEntity<?> nowMatch() {
		MatchResult result = matchResultService.nowMatch();
		return new ResponseEntity<MatchResult>(result, HttpStatus.OK);
	}
	
	@PutMapping("/finish")
	@ApiOperation(value = "매칭 끝내기(user status false로 돌려놓기")
	public ResponseEntity<?> finishMatch(@RequestBody MatchResult result) {
		matchResultService.finishMatch(result);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/updateresult")
	@ApiOperation(value = "매치 결과 등록")
	public ResponseEntity<?> updateResult(@RequestBody MatchResult result) {
		matchResultService.updateResult(result);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/oppopast")
	@ApiOperation(value = "상대방과의 과거 전적 출력")
	public ResponseEntity<?> oppoPastMatching(@RequestBody MatchResult result) {
		List<MatchResult> list = matchResultService.oppoPastMatching(result);
		return new ResponseEntity<List<MatchResult>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/past/{loginId}")
	@ApiOperation(value = "유저의 과거 경기 전적")
	public ResponseEntity<?> pastMatching(@PathVariable String loginId) {
		List<MatchResult> list = matchResultService.pastMatching(loginId);
		return new ResponseEntity<List<MatchResult>>(list, HttpStatus.OK);
	}
	
}