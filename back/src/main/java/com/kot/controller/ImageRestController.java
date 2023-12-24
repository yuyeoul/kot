package com.kot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kot.model.dto.Image;
import com.kot.model.service.ImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/image")
@Api(tags = "이미지 컨트롤러")
public class ImageRestController {
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/")
	@ApiOperation(value = "프로필 사진 등록")
	public ResponseEntity<Integer> insertImg(@RequestBody Image image) {
		int result = imageService.insertImg(image);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	@ApiOperation(value = "프로필 사진 변경")
	public ResponseEntity<?> updateImg(@RequestBody Image image) {
		imageService.updateImg(image);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{loginId}")
	@ApiOperation(value = "프로필 사진 읽기")
	public ResponseEntity<?> readImg(@PathVariable String loginId) {
		Image image = imageService.readImg(loginId);
		return new ResponseEntity<Image>(image, HttpStatus.OK);
	}
	
}