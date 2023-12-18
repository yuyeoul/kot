package com.kot.model.service;

import java.util.List;

import com.kot.model.dto.Reply;

public interface ReplyService {
	//해당 게시글의 댓글 모두 불러오기
	List<Reply> allReply(int boardId);
	//댓글 작성
	int writeReply(Reply reply);
	//댓글 수정
	void updateReply(Reply reply);
	//댓글 삭제
	void deleteReply(Reply reply);
}