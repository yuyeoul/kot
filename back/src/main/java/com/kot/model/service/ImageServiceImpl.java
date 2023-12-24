package com.kot.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.model.dao.ImageDao;
import com.kot.model.dto.Image;

@Service
public class ImageServiceImpl implements ImageService {

	private ImageDao imageDao;
	
	@Autowired
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	@Override
	public int insertImg(Image image) {
		// TODO Auto-generated method stub
		return imageDao.insertImg(image);
	}

	@Override
	public void updateImg(Image image) {
		// TODO Auto-generated method stub
		imageDao.updateImg(image);
	}

	@Override
	public Image readImg(String loginId) {
		// TODO Auto-generated method stub
		return imageDao.readImg(loginId);
	}
	
}