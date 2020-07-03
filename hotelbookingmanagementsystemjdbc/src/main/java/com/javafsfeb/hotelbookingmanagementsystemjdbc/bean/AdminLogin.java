package com.javafsfeb.hotelbookingmanagementsystemjdbc.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * Admin Login using Login credentials
 *
 */
@Data
public class AdminLogin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminLogin() {

	}

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//		

	}
