package com.javafsfeb.hotelbookingmanagementsystemjdbc.service;

import java.io.IOException;
import java.util.List;


import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Booking;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.CustomerRegistration;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Hotel;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Room;


public interface Service {

	public boolean nameValidation(String name);

	boolean userNameValidation(String userName);

	boolean passwordValidation(String password);

	boolean emailIdValidation(String emailId);

	boolean mobileNoValidation(String mobileNo);

	boolean ageValidation(String age);

	boolean addCustomerInfo(CustomerRegistration customerRegistration);

	boolean choiceValidate(String choice);

	public boolean getLoginCustomer(String username, String password);

	public boolean getAdminLogin(String username, String password) throws IOException;

	public boolean getHotelManagementLogin(String username, String password);

	public boolean choiceValidateCustomerOperations(String choice);

	public boolean choiceValidateAdminOperations(String choice);

	public boolean choiceValidateHotelManagementOperations(String choice);

	public List<Hotel> listOfHotel(Hotel hotel);

	public boolean roomNumberValidation(String roomNo);

	public List<Booking> bookingsList(Booking booking);

	public boolean bookingForHotel(String hotelName);

	public boolean hotelNameValidation(String hotelName);

	public boolean bookingDateValidation(String bookingDate);

	public boolean addressValidation(String address);

	public boolean addBooking(Booking booking);

	public List<CustomerRegistration> customersList(CustomerRegistration customerRegistration);

	public boolean bookingNameValidation(String name);

	public boolean addHotel(Hotel hotel);

	public boolean choiceValidateOperateHotelDetails(String choice);

	public boolean hotelAddressValidation(String address);

	public boolean deleteHotel(String hotelName);

	public boolean numOfRoomsValidation(String choice);

	public boolean updateHotel(String hotelName);

	public String roomTypeValidation(int choice);

	public boolean roomPriceValidation(String price);

	public boolean addRoom(Room room);

	public boolean deleteRoom(String roomNum);

	public boolean updateRoom(int roomNum);

	public List<Booking> getBookingList();

	public boolean dateValidation(String bookDate);

	public boolean updateHotelDetails(String hotelName1, Hotel hotel);

	public boolean updateRoomDetails(int roomNumber, Room room);

	public List<Hotel> listOfHotel();
}
