package com.kot.model.dao;

import java.util.List;

import com.kot.model.dto.MatchWait;

public interface MatchWaitDao {
	//매칭 신청
	int sendWait(MatchWait wait);
	//매칭 수락
	int acceptWait(MatchWait wait);
	int startMatch(MatchWait wait); //실제 매칭 시작
	int deleteAllWait(MatchWait wait); //남아있는 신청 모두 삭제
	//매칭 거절
	int deleteWait(MatchWait wait);
	//들어온 매칭 확인
	List<MatchWait> receivedWait(String receiver);
	//보낸 매칭 확인
	List<MatchWait> sentWait(String sender);
}