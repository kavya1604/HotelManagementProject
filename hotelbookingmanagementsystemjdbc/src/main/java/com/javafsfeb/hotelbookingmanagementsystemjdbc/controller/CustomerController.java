package com.javafsfeb.hotelbookingmanagementsystemjdbc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Booking;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.CustomerRegistration;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Hotel;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.exception.HotelNameNotFoundException;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.factory.Factory;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.service.Service;
/**
 * This class contains operations performed by customer
 *
 */
public class CustomerController {
	public CustomerController() {

	}

	static Scanner scanner = new Scanner(System.in);
	static final Logger log = Logger.getLogger(CustomerController.class);
	private static final Hotel hotel = null;
	static Service service = Factory.getServiceInstance();

	/**
	 * This method is used for Customer Registration
	 */
	public static void register() {

		log.info("Enter your name(without spaces,only characters are allowed)");
		String name = scanner.next();
		while (!service.nameValidation(name)) {
			log.error("please enter valid name(without spaces,only characters are allowed)");
			name = scanner.next();
		}

		log.info("Enter username(start with digits or characters,-,_)");
		String username = scanner.next();
		while (!service.userNameValidation(username)) {
			log.error("please enter valid username(start with digits or characters,-,_)");
			username = scanner.next();
		}

		log.info(
				"Enter password(must contain uppercase letter,lowercase letter,special characters @#$%,atleast one digit,minimum 6 max 20)");
		String password = scanner.next();
		while (!service.passwordValidation(password)) {
			log.error(
					"please enter valid password(must contain uppercase letter,lowercase letter,special characters @#$%,atleast one digit,minimum 6 max 20)");
			password = scanner.next();
		}

		log.info("Enter phno(start with 6,7,8,9)");
		String phone = scanner.next();
		while (!service.mobileNoValidation(phone)) {
			log.error("please enter valid phno(start with 7,8,9)");
			phone = scanner.next();
		}
		long phno = Long.parseLong(phone);

		log.info("Enter mailId(must contain @ .)");
		String mailid = scanner.next();
		while (!service.emailIdValidation(mailid)) {
			log.error("please enter valid mailid(must contain @ .)");
			mailid = scanner.next();
		}
		log.info("Enter your age(2 digits)");
		String age1 = scanner.next();
		while (!service.ageValidation(age1)) {
			log.error("please enter valid age(2 digits)");
			age1 = scanner.next();

		}
		int age = Integer.parseInt(age1);

		CustomerRegistration customerRegistration = Factory.getCustomerRegistrationInstance();
		customerRegistration.setName(name);
		customerRegistration.setUserName(username);
		customerRegistration.setPassword(password);
		customerRegistration.setMailId(mailid);
		customerRegistration.setPhno(phno);
		customerRegistration.setAge(age);
		boolean add = service.addCustomerInfo(customerRegistration);
		if (add)
			log.info("Registration success");
		else
			log.info("Registration failed");

	}

	/**
	 * Customer Can Login using Login Credentials
	 */

	public static void login() {
		log.info("Enter username(start with digits or characters,-,_)");
		String userName = scanner.nextLine();
		while (!service.userNameValidation(userName)) {
			log.error("please enter valid username(start with digits or characters,-,_)");
			userName = scanner.nextLine();
		}

		log.info(
				"Enter password(must contain uppercase,lowercase letter,special characters @#$%,atleast one digit,minimum 6 max 20)");
		String password = scanner.next();
		while (!service.passwordValidation(password)) {
			log.error(
					"please enter valid password(must contain uppercase,lowercase letter,special characters @#$%,atleast one digit,min 6 max 20)");
			password = scanner.next();
		}

		if ((service.getLoginCustomer(userName, password) == true)) {
			log.info("Login successfull");
			customerLoginOperations();
		} else {
			log.error("Login fail");
		}
	}

	/**
	 * Operations which was performed by Customer
	 */

	public static boolean customerLoginOperations() {
		P: do {
			log.info("Select options below");
			log.info("1.Hotel Booking");
			log.info("2.Exit");
			String choice = scanner.next();
			while (!service.choiceValidateCustomerOperations(choice)) {
				log.error("enter the valid choice [1-2]");
				choice = scanner.next();
			}
			int option = Integer.parseInt(choice);
			switch (option) {
			case 1:
				bookingHotel();
				break;
			case 2:
				break P;

			}
		} while (true);
		return false;
	}

	/**
	 * This method returns list of hotels and booking for specific hotel
	 */

	public static void bookingHotel() {

		log.info("Please select, which hotel you want to book");
		List<Hotel> hotelList = service.listOfHotel(hotel);
		for (Hotel h : hotelList) {

			log.info(h.getHotelName());
		}
		log.info("Please enter hotel name(without spaces,only characters are allowed)");
		String hotelName = scanner.next();
		while (!service.hotelNameValidation(hotelName)) {
			log.error("please enter valid hotel name(without spaces,only characters are allowed)");
			hotelName = scanner.next();
		}

		try {
			int check = 0;

			for (Hotel hotel : hotelList) {

				if (hotel.getHotelName().contentEquals(hotelName))

					check++;
			}
			if (check == 0) {
				throw new HotelNameNotFoundException();
			} else {

				addBooking();
			}
		} catch (HotelNameNotFoundException e) {
			log.error("Hotel Name Not Found");
		}

	}

	/**
	 * This method contains booking Details
	 */

	public static void addBooking() {
		boolean value = true;
		boolean value1 = true;
		LocalDate fromDate = null;
		LocalDate toDate = null;
		while (value) {
			log.info("Please enter from date(FORMAT:YYYY-MM-DD)");
			String fromdate = scanner.next();
			while (!service.bookingDateValidation(fromdate)) {
				log.error("Please enter valid date(FORMAT:YYYY-MM-DD)");
			fromdate = scanner.next();
			}
			try {
				fromDate = LocalDate.parse(fromdate);
				while (fromDate.isBefore(LocalDate.now())) {
			log.info("please enter a valid Date(YYYY-MM-DD)");
					fromdate = scanner.next();
					while (!service.bookingDateValidation(fromdate)) {
						log.error("Please enter valid date in the format  YYYY-MM-DD");
						fromdate = scanner.next();
					}
					fromDate = LocalDate.parse(fromdate);

				}

				value = false;
			} catch (DateTimeParseException exception) {
				log.info(exception.getMessage());
				value = true;
				fromdate = scanner.next();
			}
		}
		while (value1) {
			log.info("Please enter To date(FORMAT:YYYY-MM-DD)");
			String todate = scanner.next();
			while (!service.bookingDateValidation(todate)) {
				log.error("Please enter valid date(FORMAT:YYYY-MM-DD)");
				todate = scanner.next();
			}
			try {
				toDate = LocalDate.parse(todate);
				if (toDate.isBefore(fromDate)) {
					log.info("please enter a valid Date(YYYY-MM-DD)");
					todate = scanner.next();
					while (!service.bookingDateValidation(todate)) {
						log.error("Please enter valid date in the format  YYYY-MM-DD");
						todate = scanner.next();
					}
					toDate = LocalDate.parse(todate);

				}

				value1 = false;
			} catch (DateTimeParseException exception) {
				log.info(exception.getMessage());
				value = true;
				todate = scanner.nextLine();
			}
		}

		log.info("Please enter your name(without spaces,only characters are allowed)");
		String name = scanner.next();
		while (!service.bookingNameValidation(name)) {
			log.error("please enter valid name(without spaces,only characters are allowed)");
			name = scanner.next();
		}

		log.info("Please enter your address(starts with digits,characters,min 6 to max 200)");
		String address = scanner.next();
		while (!service.addressValidation(address)) {
			log.error("Please enter valid  address(starts with digits,characters,min 6 to max 200)");
			address = scanner.next();
		}

		log.info("Please enter email(include @ .)");
		String email = scanner.next();
		while (!service.emailIdValidation(email)) {
			log.error("Please enter valid  email(include @ .)");
			email = scanner.next();
		}

		log.info("Please enter contact number(start with 6,7,8,9)");
		String contactNumber = scanner.next();
		while (!service.mobileNoValidation(contactNumber)) {
			log.error("Please enter valid contact number(start with 7,8,9)");
			contactNumber = scanner.next();
		}

		Long contactNumber1 = Long.parseLong(contactNumber);

		log.info("Please enter room number(must have 3 digits)");
		String roomNum = scanner.next();
		while (!service.roomNumberValidation(roomNum)) {
			log.info("please enter valid room number(must have 3 digits)");
			roomNum = scanner.next();
		}
		int roomNum1 = Integer.parseInt(roomNum);

		Booking booking = Factory.getBookingInstance();

		booking.setFromDate(fromDate);
		booking.setToDate(toDate);
		booking.setName(name);
		booking.setAddress(address);
		booking.setEmail(email);
		booking.setContactNumber(contactNumber1);
		booking.setRoomNum(roomNum1);
		boolean add = service.addBooking(booking);
		if (add == true) {
			log.info("Booking successfull\n");
			log.info("Booking Details:\n " + booking.toString());
		} else {
			log.error("Booking failed");

		}
	}
}