package com.kot.model.service;

import java.util.List;

import com.kot.model.dto.MatchWait;

public interface MatchWaitService {
	//매칭 신청
	int sendWait(MatchWait wait);
	//매칭 수락
	void acceptWait(MatchWait wait); //status 변경
	void startMatch(MatchWait wait); //실제 매칭 시작
	void deleteAllWait(MatchWait wait); //남아있는 신청 모두 삭제
	//매칭 거절
	void deleteWait(MatchWait wait);
	//들어온 매칭 확인
	List<MatchWait> receivedWait(String receiver);
	//보낸 매칭 확인
	List<MatchWait> sentWait(String sender);
}