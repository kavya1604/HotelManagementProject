package com.javafsfeb.hotelbookingmanagementsystemjdbc.validations;

public interface InputValidation {
	
	public boolean nameValidation(String name);

	public boolean emailValidation(String email);

	public boolean phnoValidation(String phno);

	public boolean choiceValidate(String choice);

	public boolean usernameValidation(String username);

	public boolean passwordValidation(String password);

	public boolean ageValidation(String age);

	public boolean choiceValidateAdminOperation(String choice);

	public boolean choiceValidateBookingForSpecificHotel(String choice);

	public boolean bookingDateValidation(String bookingDate);

	public boolean hotelNameValidation(String hotelName);

	public boolean hotelAddressValidation(String hotelAddress);

	public boolean hotelContactNumberValidation(String contactNumber);

	public boolean choiceValidateOperateHotelDetails(String choice);

	public boolean choiceValidateOperateRoomDetails(String choice);

	public boolean choiceValidateCustomerOperations(String choice);

	public boolean choiceValidateEmployeeOperations(String choice);

	public boolean roomNumberValidation(String roomNum);

	public String roomTypeValidation(int choice);

	public boolean numberOfRoomsValidation(String noOfRooms);

	public boolean bookingNameValidation(String name);

	public boolean priceValidation(String price);
}
