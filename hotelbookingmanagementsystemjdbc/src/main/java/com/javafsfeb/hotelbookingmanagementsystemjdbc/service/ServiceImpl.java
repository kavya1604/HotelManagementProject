package com.javafsfeb.hotelbookingmanagementsystemjdbc.service;

import java.io.IOException;

import java.util.List;


import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Booking;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.CustomerRegistration;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Hotel;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Room;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.dao.Dao;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.factory.Factory;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.validations.InputValidation;



public class ServiceImpl implements Service {
	InputValidation inputValidation = Factory.getInputValidationInstance();
	Dao dao = Factory.getDaoInstance();

	public boolean nameValidation(String name) {
		return inputValidation.nameValidation(name);
	}

	public boolean userNameValidation(String userName) {
		return inputValidation.usernameValidation(userName);
	}

	public boolean passwordValidation(String password) {
		return inputValidation.passwordValidation(password);
	}

	public boolean emailIdValidation(String emailId) {
		return inputValidation.emailValidation(emailId);
	}

	public boolean mobileNoValidation(String mobileNo) {
		return inputValidation.phnoValidation(mobileNo);
	}

	public boolean ageValidation(String age) {
		return inputValidation.ageValidation(age);
	}

	public boolean addCustomerInfo(CustomerRegistration customerRegistration) {

		if (customerRegistration != null) {
			return dao.addCustomer(customerRegistration);
		}
		return false;
	}

	public boolean choiceValidate(String choice) {
		return inputValidation.choiceValidate(choice);
	}

	public boolean getLoginCustomer(String username, String password) {
		if (username != null) {
			return dao.getLoginRequest(username, password);
		}
		return false;
		
			}

	public boolean getAdminLogin(String userName, String password) throws IOException {
		return dao.getAdminLoginRequest(userName, password);
	}

	public boolean getHotelManagementLogin(String username, String password) {
		return dao.getHotelManagementLoginRequest(username, password);
	}

	public boolean choiceValidateCustomerOperations(String choice) {
		return inputValidation.choiceValidateCustomerOperations(choice);
	}

	public boolean choiceValidateAdminOperations(String choice) {
		return inputValidation.choiceValidateAdminOperation(choice);

	}

	public boolean choiceValidateHotelManagementOperations(String choice) {

		return inputValidation.choiceValidateEmployeeOperations(choice);
	}

	public List<Hotel> listOfHotel(Hotel hotel) {
		return dao.getAllHotels(hotel);
	}

	public List<Booking> bookingsList(Booking booking) {
		return dao.getAllBookingsList(booking);
	}

	public boolean bookingForHotel(String hotelName) {
		if (hotelName != null) {
			return dao.getBookingForHotel(hotelName);
		}
		return false;
	}

	public boolean hotelNameValidation(String hotelName) {
		return inputValidation.hotelNameValidation(hotelName);
	}

	public boolean bookingDateValidation(String bookingDate) {
		return inputValidation.bookingDateValidation(bookingDate);
	}

	public boolean addressValidation(String address) {
		return inputValidation.hotelAddressValidation(address);
	}

	public boolean roomNumberValidation(String roomNo) {
		return inputValidation.roomNumberValidation(roomNo);
	}

	public boolean addBooking(Booking booking) {
		if (booking != null) {

			return dao.addBooking(booking);
		}
		return false;
	}

	public List<CustomerRegistration> customersList(CustomerRegistration customerRegistration) {
		return dao.getAllCustomers(customerRegistration);
	}

	public boolean bookingNameValidation(String hotelName) {
		return inputValidation.bookingNameValidation(hotelName);
	}

	public boolean addHotel(Hotel hotel) {
		if (hotel != null) {
			return dao.addHotel(hotel);
		}
		return false;
	}

	public boolean choiceValidateOperateHotelDetails(String choice) {
		return inputValidation.choiceValidateOperateHotelDetails(choice);
	}

	public boolean hotelAddressValidation(String address) {
		return inputValidation.hotelAddressValidation(address);
	}

	public boolean deleteHotel(String hotelName) {
		if (hotelName != null) {
			return dao.deleteHotel(hotelName);
		}
		return false;
	}

	public boolean numOfRoomsValidation(String choice) {
		return inputValidation.numberOfRoomsValidation(choice);
	}

	public boolean updateHotel(String hotelName) {
		if (hotelName != null) {

			return dao.updateHotel(hotelName);
		}
		return false;
	}

	public String roomTypeValidation(int choice) {
		return inputValidation.roomTypeValidation(choice);
	}

	public boolean roomPriceValidation(String price) {
		return inputValidation.priceValidation(price);
	}

	public boolean addRoom(Room room) {
		if (room != null) {

			return dao.addRoom(room);
		}
		return false;
	}

	public boolean deleteRoom(String roomNum) {
		if (roomNum != null) {

			return dao.deleteRoom(roomNum);
		}
		return false;
	}

	public boolean updateRoom(int roomNum) {
		return dao.updateRoom(roomNum);
	}

	public List<Booking> getBookingList() {
		return dao.getBookingListRequest();
	}

	public boolean dateValidation(String bookingDate) {
		return inputValidation.bookingDateValidation(bookingDate);
	}

	public boolean updateHotelDetails(String hotelName1, Hotel hotel) {

		return dao.updateHotelDetails(hotelName1, hotel);
	}

	public boolean updateRoomDetails(int roomNumber, Room room) {

		return dao.updateRoomDetails(roomNumber, room);
	}

	public List<Hotel> listOfHotel() {
		return dao.getHotelList();
	}

}