package com.kot.model.service;

import java.util.List;

import com.kot.model.dto.MatchWait;

public interface MatchWaitService {
	//매칭 신청
	int sendWait(MatchWait wait);
	//매칭 수락
	//1.match를 true로 만들어주기
	void acceptWait(MatchWait wait);
	//2.status도 들어와있던 매칭 모두에 대해 true로 만들어주기(=delstatus)
	void deleteAllWait(MatchWait wait);
	//3.user_status도 true로 만들어주기(이걸 통해 다른 사람이 나한테 매칭을 보내지 못하도록 한다)
	void startMatch(MatchWait wait);
	//4.matchResult table에 insert 해주기
	int insertMatch(MatchWait wait);
	//매칭 거절
	void deleteWait(MatchWait wait);
	//들어온 매칭 확인
	List<MatchWait> receivedWait(String receiver);
	//보낸 매칭 확인
	List<MatchWait> sentWait(String sender);
}