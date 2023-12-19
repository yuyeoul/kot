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

import com.kot.model.dto.Board;
import com.kot.model.dto.User;
import com.kot.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/board")
@Api(tags = "board controller")
public class BoardRestController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/")
	@ApiOperation(value = "게시글 작성")
	public ResponseEntity<Integer> writeBoard(@RequestBody Board board) {
		int result = boardService.writeBoard(board);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	@ApiOperation(value = "게시글 수정")
	public ResponseEntity<Board> updateBoard(@RequestBody Board board) {
		boardService.updateBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	@PutMapping("/del")
	@ApiOperation(value = "게시글 삭제")
	public ResponseEntity<Board> deleteBoard(@RequestBody Board board) {
		boardService.deleteBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	@GetMapping("/")
	@ApiOperation(value = "게시글 전체 조회 ")
	public ResponseEntity<?> totalBoard() {
		List<Board> list =boardService.totalBoard();
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	
	@GetMapping("{boardId}")
	@ApiOperation(value = "게시글 한개 조회 ")
	public ResponseEntity<?> oneBoard(@PathVariable int boardId) {
		Board board = boardService.oneboard(boardId);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	@GetMapping("/search/{search}")
	@ApiOperation(value = "게시글 검색 ")
	public ResponseEntity<?> searchBoard(@PathVariable String search) {
		List<Board> slist=boardService.searchBoard(search);
		return new ResponseEntity<List<Board>>(slist, HttpStatus.OK);
	}
	
	
}
