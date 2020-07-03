package com.javafsfeb.hotelbookingmanagementsystemjdbc.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidationImpl implements InputValidation {
	Pattern pattern = null;
	Matcher matcher = null;

	public boolean nameValidation(String name) {
		pattern = Pattern.compile("[a-z]*");
		matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public boolean emailValidation(String email) {
		pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean phnoValidation(String phno) {
		pattern = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		matcher = pattern.matcher(phno);
		return matcher.matches();
	}

	public boolean choiceValidate(String choice) {
		pattern = Pattern.compile("[1-5]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean usernameValidation(String username) {
		pattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
		matcher = pattern.matcher(username);
		return matcher.matches();
	}

	public boolean passwordValidation(String password) {
		pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	public boolean ageValidation(String age) {
		pattern = Pattern.compile("[1-9]{1}[0-9]{1}");
		matcher = pattern.matcher(age);
		return matcher.matches();
	}

	public boolean choiceValidateAdminOperation(String choice) {
		pattern = Pattern.compile("[1-7]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean choiceValidateBookingForSpecificHotel(String choice) {
		pattern = Pattern.compile("[1-2]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean choiceValidateGuestListForSpecificHotel(String choice) {
		pattern = Pattern.compile("[1-2]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean bookingDateValidation(String bookingDate) {
		if (bookingDate.matches("^(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
			return true;
		}
		return false;
	}

	public boolean hotelNameValidation(String hotelName) {
		pattern = Pattern.compile("[A-Za-z]*");
		matcher = pattern.matcher(hotelName);
		return matcher.matches();
	}

	public boolean hotelAddressValidation(String hotelAddress) {
		pattern = Pattern.compile("[\\w+\\s+\\W]{6,200}");
		matcher = pattern.matcher(hotelAddress);
		return matcher.matches();
	}

	public boolean hotelContactNumberValidation(String contactNumber) {
		if (contactNumber.matches("(0/91)?[7-9][0-9]{9}")) {
			return true;
		}
		return false;
	}

	public boolean choiceValidateOperateHotelDetails(String choice) {
		pattern = Pattern.compile("[1-4]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean choiceValidateOperateRoomDetails(String choice) {
		pattern = Pattern.compile("[1-5]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean choiceValidateCustomerOperations(String choice) {
		pattern = Pattern.compile("[1-2]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean choiceValidateEmployeeOperations(String choice) {
		pattern = Pattern.compile("[1-4]");
		matcher = pattern.matcher(choice);
		return matcher.matches();
	}

	public boolean roomNumberValidation(String roomNum) {
		pattern = Pattern.compile("[1-9]{1}[0-9]{1}[0-9]{1}");
		matcher = pattern.matcher(roomNum);
		return matcher.matches();
	}

	public String roomTypeValidation(int choice) {
		switch (choice) {
		case 1:
			return "single";
		case 2:
			return "double";
		default:
			return null;
		}

	}

	public boolean numberOfRoomsValidation(String noOfRooms) {
		pattern = Pattern.compile("\\d{2}");
		matcher = pattern.matcher(noOfRooms);
		return matcher.matches();

	}

	public boolean bookingNameValidation(String name) {
		pattern = Pattern.compile("[a-z]*");
		matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public boolean priceValidation(String price) {
		pattern = Pattern.compile("\\d{0,8}[.]?\\d{1,4}$");
		matcher = pattern.matcher(price);
		return matcher.matches();

	}
}
