package com.kot.model.dto;

import java.util.Date;

public class Board {
	private int boardId;
	private int userId;
	private String title;
	private String content;
	private Date regdate;
	private int view;
	private boolean delstatus;
	
	public Board() {
	}

	public Board(int boardId, int userId, String title, String content, Date regdate, int view, boolean delstatus) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.view = view;
		this.delstatus = delstatus;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public boolean isDelstatus() {
		return delstatus;
	}

	public void setDelstatus(boolean delstatus) {
		this.delstatus = delstatus;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", view=" + view + ", delstatus=" + delstatus + "]";
	};
}