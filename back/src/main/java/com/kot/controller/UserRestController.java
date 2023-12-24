package com.kot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kot.model.dto.User;
import com.kot.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	@ApiOperation(value = "회원 가입")
	public ResponseEntity<Integer> signup(@RequestBody User user) {
		int result = userService.signUp(user);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/checkid/{id}")
	@ApiOperation(value = "아이디 중복 체크")
	public ResponseEntity<?> checkId(@PathVariable String id) {
		User dupli = userService.checkId(id);
		return new ResponseEntity<User>(dupli, HttpStatus.OK);
	}
	
	@GetMapping("/checkphone/{phone}")
	@ApiOperation(value = "핸드폰번호 중복 체크")
	public ResponseEntity<?> checkPhone(@PathVariable String phone) {
		User dupli = userService.checkPhone(phone);
		return new ResponseEntity<User>(dupli, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "로그인")
	public ResponseEntity<?> login(@RequestBody User user) {
		User temp = userService.logIn(user);
		return new ResponseEntity<User>(temp, HttpStatus.OK);
	}
	
	@GetMapping("/search/{search}")
	@ApiOperation(value = "검색 결과")
	public ResponseEntity<?> searchUser(@PathVariable String search) {
		List<User> sList = userService.searchUser(search);
		return new ResponseEntity<>(sList, HttpStatus.OK);
	}
	
	@GetMapping("/male")
	@ApiOperation(value = "남자")
	public ResponseEntity<?> selectMale() {
		List<User> mList = userService.selectMale();
		return new ResponseEntity<>(mList, HttpStatus.OK);
	}
	
	@GetMapping("/female")
	@ApiOperation(value = "여자")
	public ResponseEntity<?> selectFemale() {
		List<User> fList = userService.selectFemale();
		return new ResponseEntity<>(fList, HttpStatus.OK);
	}
	
	@GetMapping("/selectuser")
	@ApiOperation(value = "유저 상세정보 조회")
	public ResponseEntity<?> selectUser(@RequestParam String loginId,@RequestParam String gender) {
		System.out.println(loginId);
		System.out.println(gender);
		User user =userService.selectUser(loginId,gender);
	
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping("/updatepass")
	@ApiOperation(value = "유저 비밀번호 업데이트")
	public ResponseEntity<?> updatePass(@RequestBody User user) {
		userService.updatePass(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("updateRate")
	@ApiOperation(value = "유저 점수 업데이트")
	public ResponseEntity<?> updateRate(@RequestBody User user) {
		userService.updateRate(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}