package com.kot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.model.dao.MatchWaitDao;
import com.kot.model.dto.MatchWait;

@Service
public class MatchWaitServiceImpl implements MatchWaitService {

	@Autowired
	private MatchWaitDao matchWaitDao;
	
	@Override
	public int sendWait(MatchWait wait) {
		// TODO Auto-generated method stub
		return matchWaitDao.sendWait(wait);
	}

	@Override
	public void acceptWait(MatchWait wait) {
		// TODO Auto-generated method stub
		matchWaitDao.acceptWait(wait);
	}
	
	@Override
	public void deleteAllWait(MatchWait wait) {
		matchWaitDao.deleteAllWait(wait);
	}
	
	@Override
	public void startMatch(MatchWait wait) {
		// TODO Auto-generated method stub
		matchWaitDao.startMatch(wait);
	}

	@Override
	public void deleteWait(MatchWait wait) {
		// TODO Auto-generated method stub
		matchWaitDao.deleteWait(wait);
	}

	@Override
	public List<MatchWait> receivedWait(String receiver) {
		// TODO Auto-generated method stub
		return matchWaitDao.receivedWait(receiver);
	}

	@Override
	public List<MatchWait> sentWait(String sender) {
		// TODO Auto-generated method stub
		return matchWaitDao.sentWait(sender);
	}

}