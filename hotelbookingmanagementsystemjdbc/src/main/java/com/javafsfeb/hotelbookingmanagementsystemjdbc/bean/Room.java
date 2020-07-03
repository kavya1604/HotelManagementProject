package com.javafsfeb.hotelbookingmanagementsystemjdbc.bean;

import java.io.Serializable;

/**
 * This class contains Room Information
 *
 */
public class Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Room() {

	}

	private int roomNumber;
	private String roomType;
	private double roomPrice;

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomPrice=" + roomPrice + "]";
	}

}
