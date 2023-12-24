  package com.kot.model.dto;

import java.util.Date;

public class MatchResult {
	private int matchingId;
	private int matchId;
	private String user1;
	private String user1Name;
	private String user1Phone;
	private String user2;
	private String user2Name;
	private String user2Phone;
	private Date matchDate;
	private Date fdate;
	private String result;
	
	public MatchResult() {}

	public MatchResult(int matchingId, int matchId, String user1, String user1Name, String user1Phone, String user2,
			String user2Name, String user2Phone, Date matchDate, Date fdate, String result) {
		super();
		this.matchingId = matchingId;
		this.matchId = matchId;
		this.user1 = user1;
		this.user1Name = user1Name;
		this.user1Phone = user1Phone;
		this.user2 = user2;
		this.user2Name = user2Name;
		this.user2Phone = user2Phone;
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

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getUser1Name() {
		return user1Name;
	}

	public void setUser1Name(String user1Name) {
		this.user1Name = user1Name;
	}

	public String getUser1Phone() {
		return user1Phone;
	}

	public void setUser1Phone(String user1Phone) {
		this.user1Phone = user1Phone;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}

	public String getUser2Name() {
		return user2Name;
	}

	public void setUser2Name(String user2Name) {
		this.user2Name = user2Name;
	}

	public String getUser2Phone() {
		return user2Phone;
	}

	public void setUser2Phone(String user2Phone) {
		this.user2Phone = user2Phone;
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
		return "MatchResult [matchingId=" + matchingId + ", matchId=" + matchId + ", user1=" + user1 + ", user1Name="
				+ user1Name + ", user1Phone=" + user1Phone + ", user2=" + user2 + ", user2Name=" + user2Name
				+ ", user2Phone=" + user2Phone + ", matchDate=" + matchDate + ", fdate=" + fdate + ", result=" + result
				+ "]";
	}
	
}