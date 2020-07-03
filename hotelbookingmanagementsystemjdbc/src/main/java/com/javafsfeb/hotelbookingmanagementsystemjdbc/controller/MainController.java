package com.javafsfeb.hotelbookingmanagementsystemjdbc.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.factory.Factory;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.service.Service;


public class MainController {
	static final Logger log = Logger.getLogger(MainController.class);

	static Scanner scanner = new Scanner(System.in);
	static Service service = Factory.getServiceInstance();

	public static void main(String[] args) {

		log.info("Welcome To Hotel Booking Management System");
		P: do {

			log.info("1. Customer Login");
			log.info("2. Admin Login");
			log.info("3. HotelManagemet Login");
			log.info("4. Customer Registration(new user)");
			log.info("5. Exit");
			String choice1 = scanner.next();
			while (!service.choiceValidate(choice1)) {
				log.error(" enter valid choice[1-5]");
				choice1 = scanner.next();
			}
			int choice = Integer.parseInt(choice1);

			switch (choice) {
			case 1:
				CustomerController.login();
				break;
			case 2:
				AdminController.adminLogin();
				break;

			case 3:
				HotelManagementController.hotelManagementLogin();
				break;
			case 4:
				CustomerController.register();
				break;
			case 5:

				scanner.close();
				break P;

			}
		} while (true);

	}

}
