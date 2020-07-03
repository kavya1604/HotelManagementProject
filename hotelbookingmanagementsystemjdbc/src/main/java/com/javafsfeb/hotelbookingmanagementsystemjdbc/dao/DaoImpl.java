package com.javafsfeb.hotelbookingmanagementsystemjdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.AdminLogin;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Booking;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.CustomerRegistration;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Hotel;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.HotelManagementLogin;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.bean.Room;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.exception.HMSException;
import com.javafsfeb.hotelbookingmanagementsystemjdbc.utility.JdbcUtility;


/**
 * Implementation class for Dao Interface
 * 
 */
public class DaoImpl implements Dao {
	JdbcUtility dbConnector=new JdbcUtility();
	@Override
	public boolean addCustomer(CustomerRegistration customerRegistration) {
		try {
	Connection connection = dbConnector.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(dbConnector.getQuery("addUser"));
			
			pstmt.setString(1, customerRegistration.getName());
			pstmt.setString(2, customerRegistration.getUserName());
			pstmt.setString(3, customerRegistration.getPassword());
			pstmt.setLong(4, customerRegistration.getPhno());
            pstmt.setString(5, customerRegistration.getMailId());
			pstmt.setInt(6, customerRegistration.getAge());


			pstmt.executeUpdate();
			return true;

		} catch (Exception e) {
			throw new HMSException("Can't Add New Customer, as Customer Already Exists");
		}
			}
		

	@Override
	public boolean getLoginRequest(String username, String password) {
		CustomerRegistration infoBean = new CustomerRegistration();
		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("loginCheckUser"));
			{
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				try {
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						infoBean.setUserName(rs.getString("username"));
						infoBean.setPassword(rs.getString("password"));

						return true;
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw new HMSException("Invalid login credentials, Please enter  Correctly");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HMSException("Invalid login credentials, please Enter Correctly ");
		}
		throw new HMSException("Invalid login Credentials, please Enter correctly");
	}
		
	@Override
	public boolean getAdminLoginRequest(String username, String password) throws IOException {
		AdminLogin infoBean = new AdminLogin();
		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("loginCheckAdmin"));
			{
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				try {
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						infoBean.setUserName(rs.getString("username"));
						infoBean.setPassword(rs.getString("password"));

						return true;
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw new HMSException("Invalid login credentials, Please enter  Correctly");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HMSException("Invalid login credentials, please Enter Correctly ");
		}
		throw new HMSException("Invalid login Credentials, please Enter correctly");
	}
	
	@Override
	public boolean getHotelManagementLoginRequest(String username, String password) {
		HotelManagementLogin infoBean = new HotelManagementLogin();
		try {
			Connection conn = dbConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("loginCheckHotelManagement"));
			{
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				try {
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						infoBean.setUserName(rs.getString("username"));
						infoBean.setPassword(rs.getString("password"));

						return true;
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw new HMSException("Invalid login credentials, Please enter  Correctly");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HMSException("Invalid login credentials, please Enter Correctly ");
		}
		throw new HMSException("Invalid login Credentials, please Enter correctly");
	}
	


	@Override
	public List<Hotel> getAllHotels(Hotel hotel) {

		List<Hotel> hotelList = new LinkedList<Hotel>();
		try (Connection conn = dbConnector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(dbConnector.getQuery("showHotels"))) {
			while (resultSet.next()) {
				Hotel info = new Hotel();
				
				info.setHotelName(resultSet.getString("hotelname"));
				info.setHotelAddress(resultSet.getString("hoteladdress"));
				info.setNoOfRooms(resultSet.getInt("numofrooms"));
				info.setContactNumber(resultSet.getLong("contactnumber"));
				
			
				hotelList.add(info);
			}
			if (hotelList.isEmpty()) {
				throw new HMSException("No Hotels Present in the List");
			} else {
				return hotelList;
			}
		} catch (Exception e) {
			throw new HMSException(e.getMessage());
		}
	}
	@Override
	public List<Booking> getAllBookingsList(Booking booking) {
		List<Booking> bookList = new LinkedList<Booking>();
		try (Connection conn = dbConnector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(dbConnector.getQuery("showBookings"))) {
			while (resultSet.next()) {
				Booking info = new Booking();
				
                info.setFromDate(resultSet.getDate("fromdate").toLocalDate());
                info.setToDate(resultSet.getDate("todate").toLocalDate());
				info.setName(resultSet.getString("name"));
				info.setHotelName(resultSet.getString("hotelname"));
				info.setAddress(resultSet.getString("address"));
                info.setEmail(resultSet.getString("email"));
                info.setContactNumber(resultSet.getLong("contact number"));
                info.setRoomNum(resultSet.getInt("room Number"));
				
				
			
				bookList.add(info);
			}
			if (bookList.isEmpty()) {
				throw new HMSException("No Bookings Present in the List");
			} else {
				return bookList;
			}
		} catch (Exception e) {
			throw new HMSException(e.getMessage());
		}
	}
	@Override
	public boolean getBookingForHotel(String hotelName) {
		try {
			Connection connection = dbConnector.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(dbConnector.getQuery("getHotel"));
					if(pstmt.equals(hotelName)) {
					return true;
					}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
					

}

	@Override
	public boolean addBooking(Booking booking) {
		try {
			Connection connection = dbConnector.getConnection();
					PreparedStatement pstmt = connection.prepareStatement(dbConnector.getQuery("addBooking"));
					
		pstmt.setDate(1,java.sql.Date.valueOf( booking.getFromDate()));
			pstmt.setDate(2,java.sql.Date.valueOf( booking.getToDate()));
					pstmt.setString(3, booking.getHotelName());
					pstmt.setString(4, booking.getAddress());
		            pstmt.setString(5, booking.getEmail());
					pstmt.setLong(6, booking.getContactNumber());
					pstmt.setInt(7, booking.getRoomNum());

					pstmt.executeUpdate();
				} catch (Exception e) {
					throw new HMSException("Can't Add New Booking, as Booking Details Already Exists");
				}
		return true;

	}

	@Override
	public List<CustomerRegistration> getAllCustomers(CustomerRegistration customerRegistration) {
		try (Connection connection = dbConnector.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(dbConnector.getQuery("showcustomers"));) {
								List<CustomerRegistration> customerInfo = new ArrayList<CustomerRegistration>();
						while (resultSet.next()) {
							CustomerRegistration customer = new CustomerRegistration();
							customer.setName(resultSet.getString("name"));
							customer.setUserName(resultSet.getString("username"));
							customer.setPassword(resultSet.getString("password"));
							customer.setPhno(resultSet.getLong("contact number"));
							customer.setMailId(resultSet.getString("email"));
                                customer.setAge(resultSet.getInt("age"));
							
														customerInfo.add(customer);
						}
						if(customerInfo.isEmpty()) {
							throw new HMSException("No Bookings Present in the List");
						} else {
							return customerInfo;
						}
					} catch (Exception e) {
						throw new HMSException(e.getMessage());
					}
				}

	@Override
	public boolean addHotel(Hotel hotel) {

		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("addHotel"));) {
			pstmt.setString(1, hotel.getHotelName());
			pstmt.setString(2, hotel.getHotelAddress());
			pstmt.setInt(3, hotel.getNoOfRooms());
			pstmt.setLong(4, hotel.getContactNumber());
						pstmt.executeUpdate();

		} catch (Exception e) {
			throw new HMSException("Can't Add Hotel, as Hotel Already Exists");
		}
		return true;	
		}

	@Override
	public boolean deleteHotel(String hotelName) {
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("removeHotel"));) {
			pstmt.setString(1, hotelName);
			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}

		} catch (Exception e) {
			throw new HMSException(e.getMessage());

		}
		throw new  HMSException("Hotel Name Not Found");
	}		
	
	@Override
	public boolean updateHotel(String hotelName) {
List<Hotel> hotelList = new LinkedList<Hotel>();
		
		try (Connection connection = dbConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(dbConnector.getQuery("updateHotel"));) {
					Hotel hotelInfo = new Hotel();
                	preparedStatement.setString(1, hotelInfo.getHotelName());
            		preparedStatement.setString(2, hotelInfo.getHotelAddress());
            		preparedStatement.setInt(3, hotelInfo.getNoOfRooms());
					preparedStatement.setLong(4, hotelInfo.getContactNumber());
			 hotelList.add(hotelInfo);
			int count = preparedStatement.executeUpdate();
					if (count != 0) {
		} 
		}catch (Exception e) {
			
			throw new HMSException(e.getMessage());

		}
		throw new  HMSException("Hotel Name Not Found");
		}
	@Override
	public Hotel getHotel(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRoom(Room room) {
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("addRoom"));) {
			pstmt.setInt(1, room.getRoomNumber());
			pstmt.setString(2, room.getRoomType());
			pstmt.setDouble(3,room.getRoomPrice());
			
						pstmt.executeUpdate();

		} catch (Exception e) {
			throw new HMSException("Can't Add Room, as Room Already Exists");
		}
		return true;	
			}

	@Override
	public boolean deleteRoom(String roomNumber) {
		try (Connection conn = dbConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dbConnector.getQuery("removeRoom"));) {
			pstmt.setString(1, roomNumber);
			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}

		} catch (Exception e) {
			throw new HMSException(e.getMessage());

		}
		throw new  HMSException("Hotel Name Not Found");
			}

	@Override
	public boolean updateRoom(int roomNumber) {
List<Room> roomList = new LinkedList<Room>();

		
		try (Connection connection = dbConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(dbConnector.getQuery("updateRoom"));) {
		Room roomInfo = new Room();
	
					preparedStatement.setInt(1, roomInfo.getRoomNumber());
					preparedStatement.setString(2, roomInfo.getRoomType());
					preparedStatement.setDouble(3, roomInfo.getRoomPrice());
					preparedStatement.setInt(4,roomNumber );
										 roomList.add(roomInfo);
		            preparedStatement.executeUpdate();
		            return true;
					
		}catch (Exception e) {
			
			//throw new HMSException("sachin");

		}
		//throw new  HMSException("Room Number Not Found");
		return false;

	}

	@Override
	public List<Booking> getBookingListRequest() {
		List<Booking> bookList = new LinkedList<Booking>();
		try (Connection conn = dbConnector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(dbConnector.getQuery("showBookings"))) {
			while (resultSet.next()) {
				Booking info = new Booking();
				
	//			info.setFromDate(resultSet.getDate(from date)("hotel name"));
	//			info.setToDate(resultSet.getDate(from date)("hotel name"));
				info.setName(resultSet.getString("name"));
				info.setHotelName(resultSet.getString("hotel name"));
				info.setAddress(resultSet.getString("address"));
                info.setEmail(resultSet.getString("email"));
                info.setContactNumber(resultSet.getLong("contact number"));
                info.setRoomNum(resultSet.getInt("room Number"));
				
				
			
				bookList.add(info);
			}
			if (bookList.isEmpty()) {
				throw new HMSException("No Bookings Present in the List");
			} else {
				return bookList;
			}
		} catch (Exception e) {
			throw new HMSException(e.getMessage());
		}

	}

	@Override
	public boolean updateHotelDetails(String hotelName1, Hotel hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoomDetails(int roomNumber, Room room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Hotel> getHotelList() {
		try (Connection connection = dbConnector.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(dbConnector.getQuery("showHotels"));) {
								List<Hotel> hotelInfo = new ArrayList<Hotel>();
						while (resultSet.next()) {
							Hotel hotel = new Hotel();
							hotel.setHotelName(resultSet.getString("hotel name"));
							hotel.setHotelAddress(resultSet.getString("address"));
							hotel.setNoOfRooms(resultSet.getInt("number of rooms"));
							hotel.setContactNumber(resultSet.getLong("contact number"));
														hotelInfo.add(hotel);
						if (hotelInfo.isEmpty()) {
							throw new HMSException("no Hotels are present in the list");
						}
						return hotelInfo;
					}
		} catch (Exception e) {
			
		}
		return null;


	}

	
}
