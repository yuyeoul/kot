package com.kot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.model.dao.ReplyDao;
import com.kot.model.dto.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;

	@Override
	public List<Reply> allReply(int boardId) {
		// TODO Auto-generated method stub
		return replyDao.allReply(boardId);
	}

	@Override
	public int writeReply(Reply reply) {
		// TODO Auto-generated method stub
		return replyDao.writeReply(reply);
	}

	@Override
	public void updateReply(Reply reply) {
		// TODO Auto-generated method stub
		replyDao.updateReply(reply);
	}

	@Override
	public void deleteReply(Reply reply) {
		// TODO Auto-generated method stub
		replyDao.deleteReply(reply);
	}

}