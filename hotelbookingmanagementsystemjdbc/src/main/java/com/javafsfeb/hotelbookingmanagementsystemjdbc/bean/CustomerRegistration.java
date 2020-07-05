package com.javafsfeb.hotelbookingmanagementsystemjdbc.bean;

import java.io.Serializable;

/**
 * This is a bean class contains booking information
 *
 */

public class CustomerRegistration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerRegistration() {

	}

	private String name;
	private String userName;
	private String password;
	private long phno;
	private String mailId;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + "\n username=" + userName + "\n password=" + password + "\n phno=" + phno + "\n mailId="
				+ mailId + "\n age=" + age + "\n===================\n";
	}
}
