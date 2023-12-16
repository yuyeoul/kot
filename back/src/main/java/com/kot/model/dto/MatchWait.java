package com.kot.model.dto;

import java.util.Date;

public class MatchWait {
	private int matchId;
	private int userId;
	private String sender;
	private String receiver;
	private boolean status; //
	private boolean match;
	private Date mdate;
	
	public MatchWait() {
	}

	public MatchWait(int matchId, int userId, String sender, String receiver, boolean status, boolean match,
			Date mdate) {
		super();
		this.matchId = matchId;
		this.userId = userId;
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
		this.match = match;
		this.mdate = mdate;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isMatch() {
		return match;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "MatchWait [matchId=" + matchId + ", userId=" + userId + ", sender=" + sender + ", receiver=" + receiver
				+ ", status=" + status + ", match=" + match + ", mdate=" + mdate + "]";
	};
}