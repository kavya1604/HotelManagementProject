package com.javafsfeb.hotelbookingmanagementsystemjdbc.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Booking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public Booking() {

	}

	private LocalDate fromDate;
	private LocalDate toDate;
	private String name;
	private String hotelName;
	private String address;
	private String email;
	private long contactNumber;
	private int roomNum;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	@Override
	public String toString() {
		return "fromDate=" + fromDate + "\n toDate=" + toDate + "\n name=" + name + "\n address=" + address
				+ "\n email=" + email + "\n contactNumber=" + contactNumber + "\n roomNum=" + roomNum
				+ "\n=======================\n";
	}

}
