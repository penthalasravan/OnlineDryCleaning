package com.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Booking;
import com.dao.IBookingRepository;
import com.exception.EmptyEntityListException;
import com.exception.EntityCreationException;
import com.exception.EntityDeletionException;
import com.exception.EntityNotFoundException;
import com.exception.EntityUpdationException;



/**********
 *          Description    	   It is a user service implementation class that defines the methods
 *                             mentioned in its interface.
 **********/
@Service

public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bookingRepository;

	/****
	 * Method:                          	addBooking
     *Description:                      	To add the booking details
     *@param booking:                       Booking's reference variable.
	 * @returns booking                  	- Adds booking data else throws Entity Creation Exception 
	 * @throws  Entity Creation Exception  	- It is raised when we cannot create booking details
	 ****/
	@Override
	public Booking addBooking(Booking booking) {
		try {
			Booking booking1 = bookingRepository.save(booking);
			return booking1;
		} catch (Exception e) {
			throw new EntityCreationException("Failed to Create Booking.");
		}
	}

	/****
	 * Method:                          	removeBooking
     *Description:                      	To remove the booking details
     *@param booking:                       Booking's reference variable.
	 * @returns booking                  	- Removes booking data else throws Entity Deletion Exception 
	 * @throws  Entity Deletion Exception  	- It is raised when we cannot remove booking details
                       
	 
	 ****/
	@Override
	public Booking removeBooking(long bookingId) {
		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		Booking booking = null;
		if (optionalBooking.isPresent()) {
			booking = optionalBooking.get();
			bookingRepository.deleteById(bookingId);
			return booking;
		} else {
			throw new EntityDeletionException("Booking With Id " + bookingId + " does Not Exist.");
		}

	}

	/****
	 * Method:                          	updateBooking
     *Description:                      	To update the booking details
     *@param booking:                       Booking's reference variable.
	 * @returns booking                 	- Updates booking data else throws Entity Updation Exception 
	 * @throws  Entity Updation Exception   - It is raised when we cannot update booking details
	 ****/
	@Override
	public Booking updateBooking(Booking booking) {
		Optional<Booking> optionalBooking = null;
		Booking booking1 = null;
		optionalBooking = bookingRepository.findById(booking.getBookingId());
		if (optionalBooking.isPresent()) {
			booking1 = bookingRepository.save(booking);
			return booking1;
		} else {
			throw new EntityUpdationException("Booking With Id " + booking.getBookingId() + "is Not Found.");
		}
	}

	/****
	 * Method:                          getBooking
     *Description:                      To display the booking by bookingId (Primary key)
     *@param bookingId:                 bookingId of the user.
	 * @returns booking              	- if booking with bookingId presents it returns booking else throws EntityNotFoundException
	 * @throws EntityNotFoundException 	-  It is raised due to invalid bookingId 
	 ****/
	@Override
	public Booking getBooking(long bookingId) {
		Booking booking1 = null;

		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if (optionalBooking.isPresent()) {
			booking1 = optionalBooking.get();
			return booking1;
		} else {
			throw new EntityNotFoundException("Booking With Id " + bookingId + " does Not Exist.");
		}
	}

	/****
	 * Method:                          getAllBookings
     *Description:                      To display all the bookings
	 * @returns List<Booking>           - It returns all the bookings present in database
	 ****/
	@Override
	public List<Booking> getAllBookings() {
		List<Booking> allBookings = new ArrayList<Booking>();
		allBookings = bookingRepository.findAll();
		if (!allBookings.isEmpty()) {
			return allBookings;
		} else {
			throw new EmptyEntityListException("No Bookings Found.");
		}
	}

	/****
	 * Method:                          getBookingsByDate
     *Description:                      To display the booking by localDate
     *@param localDate:                 localDate of the booking.
	 *@returns List<Booking>              	- if booking with localDate is present then it returns booking else throws EmptyEntityListException
	 * @throws EmptyEntityListException 	-  It is raised due to invalid  localDate 
	 ****/
	@Override
	public List<Booking> getBookingsByDate(LocalDate localDate) {
		List<Booking> bookings = new ArrayList<Booking>();

		bookings = bookingRepository.getBookingsByDate(localDate);
		if (!bookings.isEmpty()) {
			return bookings;
		} else {
			throw new EmptyEntityListException("No Bookings Found.");
		}
	}

	/****
	 * Method:                          getBookingsByCustomer
     *Description:                      To display the booking by customerId
     *@param customerId:                customerId of the booking.
	 *@returns List<Booking>              	- if booking with customerId is present then it returns booking else throws EmptyEntityListException
	 * @throws EmptyEntityListException 	-  It is raised due to invalid customerId 
	 
	 ****/
	@Override
	public List<Booking> getBookingsByCustomer(String customerId) {
		List<Booking> bookings = new ArrayList<Booking>();

		bookings = bookingRepository.getBookingsByCustomer(customerId);
		if (!bookings.isEmpty()) {
			return bookings;
		} else {
			throw new EmptyEntityListException("No Bookings Found.");
		}
	}

}
