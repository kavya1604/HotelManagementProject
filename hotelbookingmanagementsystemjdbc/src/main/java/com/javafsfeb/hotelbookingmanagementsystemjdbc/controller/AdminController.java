package com.javafsfeb.hotelbookingmanagementsystemjdbc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.AdminLogin;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Hotel;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Room;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.exception.HotelNameNotFoundException;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.exception.RoomNumberNotFoundException;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.factory.Factory;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.service.Service;


/**
 * This class contains operations which was performed by Admin
 *
 */

public class AdminController {
	static Scanner scanner = new Scanner(System.in);
	static final Logger log = Logger.getLogger(CustomerController.class);
	static Service service = Factory.getServiceInstance();
	static List<AdminLogin> adminlist = new ArrayList<AdminLogin>();

	/**
	 * Admin can login using login credentials
	 */
	public static boolean adminLogin() {
		log.info("Username : ");
		String userName = scanner.next();
		while (!service.userNameValidation(userName)) {
			log.info("please enter valid username(start with digits or characters,-,_)");
			userName = scanner.next();
		}
		log.info("Password : ");
		String password = scanner.next();
		while (!service.passwordValidation(password)) {
			log.info(
					"please enter valid password(must contain uppercase letter,lowercase letter,special characters @#$%,atleast one digit,minimum 6 max 20)");
			password = scanner.next();
		}
		try {
			if (!(service.getAdminLogin(userName, password)))
				log.error("Login fail details not matched");
			else
				log.info("Login Successful");
			adminLoginOperations();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * operations which was performed by admin
	 */

	public static boolean adminLoginOperations() {
		L: do {
			log.info(" 1. View List of Hotels");
			log.info(" 2. Operate Hotel Details");
			log.info(" 3. Operate Room Details");
			log.info(" 4. Logout\n");

			String choice = scanner.next();
			while (!service.choiceValidateAdminOperations(choice)) {
				log.error("Please enter valid choice[1-5]");
				choice = scanner.next();
			}

			int choice1 = Integer.parseInt(choice);
			switch (choice1) {

			case 1:
				listOfHotels();

				break;
			
			case 2:
				operateHotelDetails();
				break;
			case 3:
				operateRoomDetails();
				break;
			case 4:

				break L;
			}
		} while (true);

		return false;

	}

	
	/**
	 * This method returns List of hotels
	 */

	public static void listOfHotels() {

		log.info(service.listOfHotel());

	}

	/**
	 * This method returns booking details for specific date
	 */

	
	/**
	 * This method returns Hotel Details
	 */

	public static boolean operateHotelDetails() {

		L: do {

			log.info("1.Add Hotel ");
			log.info("2.Delete Hotel");
			log.info("3.Update Hotel");
			log.info("4.Exit ");
			String choice = scanner.next();
			while (!service.choiceValidateOperateHotelDetails(choice)) {
				log.error("Please enter valid choice(choice should be 1 to 4)");
				choice = scanner.next();
			}
			int choice1 = Integer.parseInt(choice);
			switch (choice1) {

			case 1:
				addHotel();
				break;

			case 2:
				deleteHotel();
				break;

			case 3:
				updateHotelDetails();
				break;

			case 4:

				break L;

			default:
				log.error("Please enter valid input");
				break;
			}

		} while (true);
		return false;

	}

	/**
	 * This method returns add hotel
	 */

	public static void addHotel() {

		log.info(" Please enter hotel name(without spaces,only characters are allowed)");
		String hotelName = scanner.next();
		while (!service.hotelNameValidation(hotelName)) {
			log.error("Please enter valid hotel name(without spaces,only characters are allowed)  ");
			hotelName = scanner.next();
		}

		log.info("Please enter hotel address(starts with digits,characters,min 6 to max 200)");
		String hotelAddress = scanner.next();
		while (!service.hotelAddressValidation(hotelAddress)) {
			log.error("Please enter valid hotel address(starts with digits,characters,min 6 to max 200)");
			hotelAddress = scanner.next();
		}

		log.info("Please enter total number of rooms in hotel(2 digits)");
		String noOfRooms = scanner.next();
		while (!service.numOfRoomsValidation(noOfRooms)) {
			log.error("please enter valid number of rooms(2 digits)");
			noOfRooms = scanner.next();
		}
		int numberOfRooms = Integer.parseInt(noOfRooms);
		log.info("Please enter contact number(must contain 10 digits and start with 6,7,8,9) ");
		String contactNumber = scanner.next();
		while (!service.mobileNoValidation(contactNumber)) {
			log.error("Please enter valid contact number(must contain 10 digits and start with 6,7,8,9)  ");
			contactNumber = scanner.next();
		}
		long hotelContactNumber = Long.parseLong(contactNumber);

		Hotel hotel = Factory.getHotelInstance();
		hotel.setHotelName(hotelName);
		hotel.setHotelAddress(hotelAddress);
		hotel.setNoOfRooms(numberOfRooms);
		hotel.setContactNumber(hotelContactNumber);

		boolean add = service.addHotel(hotel);
		if (add) {
			log.info("New  hotel details are added :\n");

		} else {
			log.info("hotel details are not added:");

		}

	}

	/**
	 * This method is used to delete hotel details
	 */

	public static void deleteHotel() {
		log.info("Please enter hotel name(without spaces,only characters are allowed)");
		String hotelName1 = scanner.next();
		while (!service.hotelNameValidation(hotelName1)) {
			log.error("Please enter valid hotel name(without spaces,only characters are allowed)");
			hotelName1 = scanner.next();
		}
		boolean add = service.deleteHotel(hotelName1);

		try {
			if (add == false) {
				throw new HotelNameNotFoundException();
			} else {
				log.info("Data Deleted successfully");
			}
		} catch (HotelNameNotFoundException e) {
			log.info("Hotel Name Not Found");

		}

	}
//	public static void updateHotel(){
//		log.info("Please select, which hotel you want to book");
//		List<Hotel> hotelList = service.listOfHotel(hotel);
//		for (Hotel h : hotelList) {
//
//			log.info(h.getHotelName());
//		}
//		log.info("Please enter hotel name(without spaces,only characters are allowed)");
//		String hotelName = scanner.next();
//		while (!service.hotelNameValidation(hotelName)) {
//			log.error("please enter valid hotel name(without spaces,only characters are allowed)");
//			hotelName = scanner.next();
//		}
//
//		try {
//			int check = 0;
//
//			for (Hotel hotel : hotelList) {
//
//				if (hotel.getHotelName().contentEquals(hotelName))
//
//					check++;
//			}
//			if (check == 0) {
//				throw new HotelNameNotFoundException();
//			} else {
//
//				updateHotelDetails();
//			}
//		} catch (HotelNameNotFoundException e) {
//			log.error("Hotel Name Not Found");
//		}
//
//	}
//
	/**
	 * This method is used to Update Hotel Details
	 */

	public static void updateHotelDetails() {

		log.info("Please enter hotel name(without spaces,only characters are allowed)");
		String hotelName1 = scanner.next();
		while (!service.hotelNameValidation(hotelName1)) {
			log.error("Please enter valid hotel name(without spaces,only characters are allowed)");
			hotelName1 = scanner.next();
		}
		boolean add = service.updateHotel(hotelName1);
		if (add) {
			log.info("Request is Done ");
			log.info(" ============= update details ==============");
			Hotel hotel = Factory.getHotelInstance();
			log.info("update hotel  name(without spaces,only characters are allowed)");
			String hotelName2 = scanner.next();
			while (!service.hotelNameValidation(hotelName2)) {
				log.error("please enter valid name(without spaces,only characters are allowed)");
				hotelName2 = scanner.nextLine();
			}
			hotel.setHotelName(hotelName2);

			log.info("update hotel address(starts with digits,characters,min 6 to max 200)");
			String hotelAdress = scanner.nextLine();
			while (!service.hotelAddressValidation(hotelAdress)) {
				log.error("please enter valid address(starts with digits,characters,min 6 to max 200)");
				hotelAdress = scanner.nextLine();
			}

			hotel.setHotelAddress(hotelAdress);

			log.info("update number of rooms(2 digits)");
			String numOfRooms = scanner.nextLine();
			while (!service.numOfRoomsValidation(numOfRooms)) {
				log.error("please enter valid number of rooms(2 digits)");
				numOfRooms = scanner.nextLine();
			}

			int numberOfRooms = Integer.parseInt(numOfRooms);
			hotel.setNoOfRooms(numberOfRooms);

			log.info("update contact number(must contain 10 digits and start with 6,7,8,9)");
			String phno = scanner.nextLine();
			while (!service.mobileNoValidation(phno)) {
				log.error("please enter valid contact number(must contain 10 digits and start with 6,7,8,9)");
				phno = scanner.nextLine();
			}
			long phno1 = Long.parseLong(phno);
			hotel.setContactNumber(phno1);
//				if (service.updateHotel(hotelName1)) {
			hotel.setHotelName(hotelName1);
				log.info("updated successfully");
			 } else {
				System.err.println("HotelName which was given is not in existing hence unable to update");
			}
	}

	/**
	 * This method is used to Operate Room Details
	 */
	public static boolean operateRoomDetails() {

		L: do {

			log.info("1.Add Room");
			log.info("2.Delete Room");
			log.info("3.Update Room");
			log.info("4.Exit ");
			String choice = scanner.next();
			while (!service.choiceValidateOperateHotelDetails(choice)) {
				log.error("Please enter valid choice(choice should be 1 to 4)");
				choice = scanner.next();
			}
			int choice1 = Integer.parseInt(choice);
			switch (choice1) {

			case 1:
				addRoom();
				break;

			case 2:
				deleteRoom();
				break;

			case 3:
				updateRoom();
				break;

			case 4:

				break L;

			default:
				log.error("Please enter valid input");
				break;
			}

		} while (true);
		return false;

	}

	/**
	 * This method is used to add Room Details
	 */
	public static void addRoom() {

		Room room = Factory.getRoomInstance();

		log.info("Please enter room number(3 digits)");
		String roomNumber1 = scanner.next();
		while (!service.roomNumberValidation(roomNumber1)) {
			log.error("please enter valid room number(3 digits) ");
			roomNumber1 = scanner.next();
		}
		int roomNumber = Integer.parseInt(roomNumber1);

		log.info(
				"Please enter room price(max 8 digits before decimal,max 4 digits after decimal,decimal point is optional)");
		String roomPrice = scanner.next();
		while (!service.roomPriceValidation(roomPrice)) {
			log.error(
					"please enter valid room price(max 8 digits before decimal,max 4 digits after decimal,decimal point is optional)");
			roomNumber1 = scanner.next();
		}
		double price = Double.parseDouble(roomPrice);
		log.info("Please select room type");
		log.info("1.single");
		log.info("2.double");
		String choice1 = scanner.next();
		while (!service.choiceValidateCustomerOperations(choice1)) {
			log.error(" enter valid choice(choice should be 1-2)");
			choice1 = scanner.next();
		}
		int choice = Integer.parseInt(choice1);
		String roomType = service.roomTypeValidation(choice);

		room.setRoomNumber(roomNumber);
		room.setRoomType(roomType);
		room.setRoomPrice(price);

		boolean add = service.addRoom(room);
		if (add == true) {
			log.info("New  room details are added :\n");

		} else {
			log.error("room details are not added:");

		}

	}

	/**
	 * This method is used to Delete Room Details
	 */
	public static void deleteRoom() {
		log.info("Please enter room number(3 digits)");
		String roomNumber = scanner.next();
		while (!service.roomNumberValidation(roomNumber)) {
			log.info("Please enter valid room Number(3 digits)");
			roomNumber = scanner.next();
		}

		boolean add = service.deleteRoom(roomNumber);
		try {
			if (add == false) {
				throw new RoomNumberNotFoundException();
			} else {
				log.info("Data Deleted successfully");
			}
		} catch (RoomNumberNotFoundException e) {
			log.error("Room Number Not Found");

		}
	}

	/**
	 * This method is used to Update Room Details
	 */
	public static void updateRoom() {
		log.info("Please enter room number(3 digits)");
		String roomNumber1 = scanner.next();
		while (!service.roomNumberValidation(roomNumber1)) {
			log.info("Please enter valid room Number(3 digits)");
			roomNumber1 = scanner.next();
		}
		int roomNumber = Integer.parseInt(roomNumber1);
		boolean add = service.updateRoom(roomNumber);
		try {
			if (add == true) {
				log.info("Request is Done ");
				log.info(" ============= update details ==============");
				Room room = Factory.getRoomInstance();
				log.info("update room number(3 digits)");
				String roomNum1 = scanner.next();
				while (!Factory.getInputValidationInstance().roomNumberValidation(roomNum1)) {
					log.info("please enter valid room number(3 digits) ");
					roomNum1 = scanner.next();
				}

				int roomNum = Integer.parseInt(roomNum1);

				room.setRoomNumber(roomNum);

				log.info(
						"Please enter room price(max 8 digits before decimal,max 4 digits after decimal,decimal point is optional)");
				String roomPrice = scanner.next();
				while (!service.roomPriceValidation(roomPrice)) {
					log.info(
							"please enter valid room price(max 8 digits before decimal,max 4 digits after decimal,decimal point is optional)");
					roomNumber1 = scanner.next();
				}
				double price = Double.parseDouble(roomPrice);
				room.setRoomPrice(price);
				log.info("update room type(single/double");

				log.info("1.single");
				log.info("2.double");
				String choice1 = scanner.next();
				while (!Factory.getInputValidationInstance().choiceValidateBookingForSpecificHotel(choice1)) {
					log.info(" enter valid choice");
					choice1 = scanner.next();
				}
				int choice = Integer.parseInt(choice1);

				String roomType = Factory.getInputValidationInstance().roomTypeValidation(choice);

				room.setRoomType(roomType);

				if (service.updateRoomDetails(roomNumber, room)) {
					log.info("updated successfully");
				} else {
					log.error("updated not successfully");
				}

			} else {
				throw new RoomNumberNotFoundException();
			}
		} catch (RoomNumberNotFoundException e) {
			log.error("Room Number not found");
		}
	}
}
