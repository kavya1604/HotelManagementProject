package com.javafsfeb.hotelbookingmanagementsystemjdbc.bean;

import java.io.Serializable;

/**
 * This class contains hotel Information
 *
 */

public class Hotel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Hotel() {

	}

	private String hotelName;
	private String hotelAddress;
	private int noOfRooms;
	private long contactNumber;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "hotelName=" + hotelName + "\n hotelAddress=" + hotelAddress + "\n noOfRooms=" + noOfRooms
				+ "\n contactNumber=" + contactNumber + "\n============\n";
	}

}
