package com.kot.model.dao;

import java.util.List;

import com.kot.model.dto.Board;

public interface BoardDao {
	//게시글 작성 
	int writeBoard(Board board);
	//게시글 수정 
	int updateBoard(Board board);
	//게시글 삭제 
	int deleteBoard(Board board);
	//게시글 전체 조회 
	List<Board> totalBoard();
	//게시글 하나 조회 
	Board oneboard(String boardId);
	//게시글 검색 
	List<Board> searchBoard(String search);
}
