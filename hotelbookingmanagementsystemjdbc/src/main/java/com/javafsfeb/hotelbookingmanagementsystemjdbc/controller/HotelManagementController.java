package com.javafsfeb.hotelbookingmanagementsystemjdbc.controller;


import java.util.Scanner;
import org.apache.log4j.Logger;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Booking;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.CustomerRegistration;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.factory.Factory;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.service.Service;

/**
 * This class contains operations which was performed by Hotel Management
 *
 */
public class HotelManagementController {
	static final Logger log = Logger.getLogger(HotelManagementController.class);

	static CustomerRegistration customerRegistration=Factory.getCustomerRegistrationInstance();
	static Booking booking=Factory.getBookingInstance();
	static Service service = Factory.getServiceInstance();
	static Scanner scanner = new Scanner(System.in);

	/**
	 * Hotel Management can Login using Login Credentials
	 */

	public static void hotelManagementLogin() {
		log.info("Enter username(start with digits or characters,-,_)");
		String username = scanner.nextLine();
		while (!service.userNameValidation(username)) {
			log.error("please enter valid username(start with digits or characters,-,_)");
			username = scanner.nextLine();
		}

		log.info(
				"Enter password(must contain uppercase letter,lowercase letter,special characters @#$%,atleast one digit,minimum 6 max 20)");
		String password = scanner.next();
		while (!service.passwordValidation(password)) {
			log.error(
					"please enter valid password(must contain uppercase letter,lowercase letter,special characters @#$%,atleast one digit,minimum 6 max 20)");
			password = scanner.next();
		}
		if (service.getHotelManagementLogin(username, password) == true) {
			log.info("Login successfull");
			HotelManagementOperations();
		} else {
			log.error("Login fail");
		}
	}

	/**
	 * Operations which was performed by Hotel Management
	 */

	public static boolean HotelManagementOperations() {
		P: do {

			log.info("1.View Customer List");
			log.info("2.View Booking List");
			log.info("3.Exit");
			String choice = scanner.next();
			while (!service.choiceValidateHotelManagementOperations(choice)) {
				log.error("Please enter valid choice[1-3]");
				choice = scanner.next();
			}

			int choice1 = Integer.parseInt(choice);

			switch (choice1) {

			case 1:
				getAllCustomerDetails();
				break;
			case 2:
				bookingsList(booking);
				break;

			case 3:
				break P;
			default:
				log.info("Enter Valid choice");
				break;
			}

		} while (true);
		return false;

	}

	/**
	 * This method returns Bookings List
	 */

	public static void bookingsList(Booking booking) {
		log.info(service.bookingsList(booking));
	}

	/**
	 * This method returns Customer List
	 */

	public static void getAllCustomerDetails() {
		log.info(service.customersList(customerRegistration));
	}

}
