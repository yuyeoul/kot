package com.kot.model.dto;

import java.util.Date;

public class Reply {
	private int replyId;
	private int boardId;
	private int userId;
	private String content;
	private Date regdate;
	private boolean delstatus;
	
	public Reply() {
	}

	public Reply(int replyId, int boardId, int userId, String content, Date regdate, boolean delstatus) {
		super();
		this.replyId = replyId;
		this.boardId = boardId;
		this.userId = userId;
		this.content = content;
		this.regdate = regdate;
		this.delstatus = delstatus;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public boolean isDelstatus() {
		return delstatus;
	}

	public void setDelstatus(boolean delstatus) {
		this.delstatus = delstatus;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", boardId=" + boardId + ", userId=" + userId + ", content=" + content
				+ ", regdate=" + regdate + ", delstatus=" + delstatus + "]";
	};
}