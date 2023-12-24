package com.kot.model.dao;

import java.util.List;

import com.kot.model.dto.MatchResult;
import com.kot.model.dto.MatchWait;

public interface MatchResultDao {
	
	//새로운 매치 정보 insert 해주기
	int insertMatch(MatchResult result);
	//현재 매치 정보 불러오기(결과가 null인거)
	MatchResult nowMatch();
	//매치 완료
	//1.user status 둘 다 false로 돌려놓기
	int finishMatch(MatchResult result);
	//2.fdate, result update해주기
	int updateResult(MatchResult result);
	//상대방과의 과거 전적 불러오기
	List<MatchResult> oppoPastMatching(MatchResult result);
	//특정 유저의 과거 전적 모두 불러오기
	List<MatchResult> pastMatching(String loginId);
	
}