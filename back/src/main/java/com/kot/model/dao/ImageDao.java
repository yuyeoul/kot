package com.kot.model.dao;

import com.kot.model.dto.Image;

public interface ImageDao {

	//등록
	int insertImg(Image image);
	//변경
	int updateImg(Image image);
	//읽기
	Image readImg(String loginId);
	
}
