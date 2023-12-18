package com.kot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.model.dao.BoardDao;
import com.kot.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int writeBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.writeBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(Board board) {
		boardDao.deleteBoard(board);
	}

	@Override
	public List<Board> totalBoard() {
		// TODO Auto-generated method stub
		return boardDao.totalBoard();
	}

	@Override
	public Board oneboard(String boardId) {
		// TODO Auto-generated method stub
		return boardDao.oneboard(boardId);
	}

	@Override
	public List<Board> searchBoard(String search) {
		// TODO Auto-generated method stub
		return boardDao.searchBoard(search);
	}

}
