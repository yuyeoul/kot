package com.kot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.model.dao.UserDao;
import com.kot.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int signUp(User user) {
		return userDao.signUp(user);
	}

	@Override
	public User checkId(String id) {
		return userDao.checkId(id);
	}

	@Override
	public User checkPhone(String phone) {
		return userDao.checkPhone(phone);
	}

	@Override
	public User logIn(User user) {
		User temp = userDao.logIn(user);
		if (temp != null && temp.getLoginId().equals(user.getLoginId())) {
			return temp;
		}
		return null;
	}

	@Override
	public List<User> searchUser(String search) {
		return userDao.searchUser(search);
	}

	@Override
	public List<User> selectMale() {
		return userDao.selectMale();
	}

	@Override
	public List<User> selectFemale() {
		return userDao.selectFemale();
	}

	@Override
	public User selectUser(String loginId,String gender) {
		return userDao.selectUser(loginId,gender);
	}

	@Override
	public void updatePass(User user) {
		userDao.updatePass(user);
	}
	
	@Override
	public void updateRate(User user) {
		userDao.updateRate(user);
	}
	
}