package com.kot.model.dao;

import java.util.List;

import com.kot.model.dto.User;

public interface UserDao {
	//회원가입
	int signUp(User user);
	User checkId(String id);
	User checkPhone(String phone);
	//로그인
	User logIn(User user);
	//검색
	List<User> searchUser(String search);
	//랭킹순으로 나열
	List<User> selectMale();
	List<User> selectFemale();
	//회원 정보 출력
	User selectUser(String loginId,String gender);
	//회원 정보 수정
	int updatePass(User user);
	//점수 업데이트
	int updateRate(User user);

}