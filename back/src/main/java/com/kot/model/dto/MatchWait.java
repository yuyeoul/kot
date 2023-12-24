package com.kot.model.dto;

import java.util.Date;

public class MatchWait {
	private int matchId;
	private int userId;
	private String sender;
	private String senderName;
	private String senderPhone;
	private String receiver;
	private String receiverName;
	private String receiverPhone;
	private boolean status; //
	private boolean match;
	private Date mdate;
	
	public MatchWait() {
	}

	public MatchWait(int matchId, int userId, String sender, String senderName, String senderPhone,
			String receiver, String receiverName, String receiverPhone, boolean status, boolean match, Date mdate) {
		super();
		this.matchId = matchId;
		this.userId = userId;
		this.sender = sender;
		this.senderName = senderName;
		this.senderPhone = senderPhone;
		this.receiver = receiver;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
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

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
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
		return "MatchWait [matchId=" + matchId + ", userId=" + userId + ", sender=" + sender + ", senderName="
				+ senderName + ", senderPhone=" + senderPhone + ", receiver=" + receiver + ", receiverName="
				+ receiverName + ", receiverPhone=" + receiverPhone + ", status=" + status + ", match=" + match
				+ ", mdate=" + mdate + "]";
	}

}