package com.kot.model.dto;

import java.util.Date;

public class MatchResult {
	private int matchingId;
	private int matchId;
	private int userId;
	private String user1;
	private String user2;
	private Date matchDate;
	private Date fdate;
	private String result;
	
	public MatchResult() {}

	public MatchResult(int matchingId, int matchId, int userId, String user1, String user2, Date matchDate, Date fdate,
			String result) {
		super();
		this.matchingId = matchingId;
		this.matchId = matchId;
		this.userId = userId;
		this.user1 = user1;
		this.user2 = user2;
		this.matchDate = matchDate;
		this.fdate = fdate;
		this.result = result;
	}

	public int getMatchingId() {
		return matchingId;
	}

	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
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

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "MatchResult [matchingId=" + matchingId + ", matchId=" + matchId + ", userId=" + userId + ", user1="
				+ user1 + ", user2=" + user2 + ", matchDate=" + matchDate + ", fdate=" + fdate + ", result=" + result
				+ "]";
	};
}