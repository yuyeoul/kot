package com.kot.model.service;

import com.kot.model.dto.Image;

public interface ImageService {
	
	//등록
	int insertImg(Image image);
	//변경
	void updateImg(Image image);
	//읽기
	Image readImg(String loginId);

}