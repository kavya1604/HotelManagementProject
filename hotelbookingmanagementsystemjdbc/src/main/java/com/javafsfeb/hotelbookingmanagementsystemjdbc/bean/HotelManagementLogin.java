package com.javafsfeb.hotelbookingmanagementsystemjdbc.bean;

import java.io.Serializable;

/**
 * HotelManagement can login using login credentials
 *
 */
public class HotelManagementLogin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelManagementLogin() {

	}

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "HotelManagementLogin [username=" + userName + ", password=" + password + "]";
	}

}
