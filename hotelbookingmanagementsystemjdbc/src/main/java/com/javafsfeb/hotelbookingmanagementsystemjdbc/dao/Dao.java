package com.javafsfeb.hotelbookingmanagementsystemjdbc.dao;

import java.io.IOException;

import java.util.List;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Booking;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.CustomerRegistration;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Hotel;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Room;
/**
 * This is an Dao interface which contains methods
 *
 */
public interface Dao {

	boolean addCustomer(CustomerRegistration customerRegistration);

	public boolean getLoginRequest(String username, String password);

	public boolean getAdminLoginRequest(String username, String password) throws IOException;

	public boolean getHotelManagementLoginRequest(String username, String password);

	public List<Hotel> getAllHotels(Hotel hotel);

	public List<Booking> getAllBookingsList(Booking booking);

	public boolean getBookingForHotel(String hotelName);

	public boolean addBooking(Booking booking);

	public List<CustomerRegistration> getAllCustomers(CustomerRegistration customerRegistration);

	public boolean addHotel(Hotel hotel);

	public boolean deleteHotel(String hotelName);

	public boolean updateHotel(String hotelName);

	public Hotel getHotel(String hotelName);

	public boolean addRoom(Room room);

	public boolean deleteRoom(String roomNumber);

	public boolean updateRoom(int roomNumber);

	public List<Booking> getBookingListRequest();

	boolean updateHotelDetails(String hotelName1, Hotel hotel);

	public boolean updateRoomDetails(int roomNumber, Room room);

	public List<Hotel> getHotelList();
}
