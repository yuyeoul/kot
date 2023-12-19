package com.kot.model.dto;

import java.util.Date;

public class User {
	private int userId;
	private String name;
	private String loginId;
	private String pass;
	private String email;
	private String phone;
	private String gender;
	private String age;
	private String address;
	private Date regDate;
	private int rate;
	private int ranking;
	private boolean status;
	
	public User() {
	};
	
	public User(int userId, String name, String loginId, String pass, String email, String phone, String gender,
			String age, String address, Date regDate, int rate, int ranking, boolean status) {
		super();
		this.userId = userId;
		this.name = name;
		this.loginId = loginId;
		this.pass = pass;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.regDate = regDate;
		this.rate = rate;
		this.ranking = ranking;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", loginId=" + loginId + ", pass=" + pass + ", email="
				+ email + ", phone=" + phone + ", gender=" + gender + ", age=" + age + ", address=" + address
				+ ", regDate=" + regDate + ", rate=" + rate + ", status=" + status + "]";
	}
}