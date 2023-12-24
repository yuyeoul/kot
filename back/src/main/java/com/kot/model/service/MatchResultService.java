package com.kot.model.service;

import java.util.List;

import com.kot.model.dto.MatchResult;

public interface MatchResultService {

	//새로운 매치 정보 insert 해주기
	int insertMatch(MatchResult result);
	//현재 매치 정보 불러오기(결과가 null인거)
	MatchResult nowMatch(String loginId);
	//매치 완료
	//1.user status 둘 다 false로 돌려놓기
	void finishMatch(MatchResult result);
	//2.fdate, result update해주기
	void updateResult(MatchResult result);
	//상대방과의 과거 전적 불러오기
	List<MatchResult> oppoPastMatching(MatchResult result);
	//특정 유저의 과거 전적 모두 불러오기
	List<MatchResult> pastMatching(String loginId);
	
}
