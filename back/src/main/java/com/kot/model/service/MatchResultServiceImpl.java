package com.kot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.model.dao.MatchResultDao;
import com.kot.model.dto.MatchResult;

@Service
public class MatchResultServiceImpl implements MatchResultService {

	@Autowired
	private MatchResultDao matchResultDao;
	
	@Override
	public MatchResult nowMatch() {
		// TODO Auto-generated method stub
		return matchResultDao.nowMatch();
	}

	@Override
	public void finishMatch(MatchResult result) {
		// TODO Auto-generated method stub
		matchResultDao.finishMatch(result);
	}

	@Override
	public void updateResult(MatchResult result) {
		// TODO Auto-generated method stub
		matchResultDao.updateResult(result);
	}

	@Override
	public List<MatchResult> oppoPastMatching(MatchResult result) {
		// TODO Auto-generated method stub
		return matchResultDao.oppoPastMatching(result);
	}

	@Override
	public List<MatchResult> pastMatching(String loginId) {
		// TODO Auto-generated method stub
		return matchResultDao.pastMatching(loginId);
	}

}
