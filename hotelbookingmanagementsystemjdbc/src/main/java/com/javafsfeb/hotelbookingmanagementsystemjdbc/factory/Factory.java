package com.javafsfeb.hotelbookingmanagementsystemjdbc.factory;

import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.AdminLogin;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Booking;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.CustomerRegistration;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Hotel;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.HotelManagementLogin;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Room;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.controller.AdminController;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.controller.CustomerController;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.controller.HotelManagementController;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.dao.Dao;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.dao.DaoImpl;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.service.Service;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.service.ServiceImpl;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.validations.InputValidation;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.validations.InputValidationImpl;

/**
 * In this class we will create objects for all classes
 *
 */
public class Factory {
	private Factory() {

	}

	public static InputValidation getInputValidationInstance() {

		return new InputValidationImpl();
	}

	public static Service getServiceInstance() {
		Service service = new ServiceImpl();
		return service;

	}

	public static CustomerRegistration getCustomerRegistrationInstance() {
		CustomerRegistration customerRegistration = new CustomerRegistration();
		return customerRegistration;
	}

	public static Dao getDaoInstance() {
		Dao dao = new DaoImpl();
		return dao;
	}

	public static AdminLogin getAdminInstance() {
		return new AdminLogin();
	}

	public static HotelManagementLogin getHotelManagementLoginInstance() {
		return new HotelManagementLogin();
	}

	public static Booking getBookingInstance() {
		return new Booking();
	}

	public static Hotel getHotelInstance() {
		return new Hotel();
	}

	public static Room getRoomInstance() {
		return new Room();
	}

	public static AdminController getAdminControllerInstance() {
		return new AdminController();
	}

	public static CustomerController getCustomerControllerInstance() {
		return new CustomerController();
	}

	public static HotelManagementController getHotelManagementControllerInstance() {
		return new HotelManagementController();
	}
}
