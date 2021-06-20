package com.rest;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Booking;
import com.service.IBookingService;

/***************

 * Description       It is a service class that provides the
 *                   services to add a statement,remove a statement,update a statement and view statement 


 ***************/

@RestController
@RequestMapping("/booking")
public class BookingRest {

	@Autowired
	private IBookingService iBookingService;

	/***********
	* Method                : addBooking
	*Description            : To add the statement to the Database
	* @param Booking        - Booking to be added to the Database
	* @param RequestBody    - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound HttpRequest body
	                          onto a Java object.
	* @returns booking      - returns booking
	
	************/
	@PostMapping("/add")
	public Booking addBooking(@RequestBody Booking booking) {
		Booking booking1 = null;
		booking1 = this.iBookingService.addBooking(booking);
		return booking1;
	}

	/**********
	* Method                : getBooking
	*Description            : To fetch the booking from the Database
	* @param bookingId      - booking to be fetched from the Database
	* @param PathVariable   - It maps the HttpRequest body to a transfer or domain object,
	                           enabling automatic deserialization of the inbound
	                            HttpRequest body onto a Java object.
	* @returns booking      - returns booking

	*********************/
	@GetMapping("/get/{bookingId}")
	public Booking getBooking(@PathVariable long bookingId) {
		Booking booking1 = this.iBookingService.getBooking(bookingId);
		return booking1;
	}
	
	/**********
	* Method                : getAllBookings
	*Description            : To fetch the bookings from the Database.
	* @returns booking      - returns list of bookings.
	
	*********************/
	@GetMapping("/all")
	public List<Booking> getAllBookings() {
		List<Booking> bookings = this.iBookingService.getAllBookings();
		return bookings;
	}

	/**********
	* Method                : removeBooking
	*Description            : To delete the booking from the Database
	* @param bookingId      - booking to be fetched from the Database
	* @param PathVariable   - It maps the HttpRequest body to a transfer or domain object,
	                           enabling automatic deserialization of the inbound
	                            HttpRequest body onto a Java object.
	* @returns booking      - returns booking


	*********************/
	@DeleteMapping("/delete/{bookingId}")
	public Booking removeBooking(@PathVariable long bookingId) {
		Booking booking1 = this.iBookingService.removeBooking(bookingId);
		return booking1;
	}

	/**********
	* Method                : updateBooking
	*Description            : To update the booking in the Database
	* @param bookingId      - booking to be fetched from the Database
	* @param PathVariable   - It maps the HttpRequest body to a transfer or domain object,
	                           enabling automatic deserialization of the inbound
	                            HttpRequest body onto a Java object.
	* @returns booking      - returns booking

	*********************/
	@PutMapping("/update")
	public Booking updateBooking(@RequestBody Booking booking) {
		Booking booking1 = this.iBookingService.updateBooking(booking);
		return booking1;
	}

	/**********
	* Method                : getBookingsByDate
	*Description            : To fetch the booking from the Database based on localDate
	* @param localDate      - booking to be fetched from the Database using the localDate
	* @param PathVariable   - It maps the HttpRequest body to a transfer or domain object,
	                           enabling automatic deserialization of the inbound
	                            HttpRequest body onto a Java object.
	* @param                - It declares that a parameter should be formatted as a date or time. 
	* @returns booking      - returns booking

	*********************/
	@GetMapping("/getbydate/{localDate}")
	public List<Booking> getBookingsByDate(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate localDate) {
		List<Booking> booking1 = this.iBookingService.getBookingsByDate(localDate);
		return booking1;
	}

	/**********
	* Method                : getBookingsByCustomer
	*Description            : To fetch the booking from the Database
	* @param customerId     - booking to be fetched from the Database using customerId
	* @param PathVariable   - It maps the HttpRequest body to a transfer or domain object,
	                           enabling automatic deserialization of the inbound
	                            HttpRequest body onto a Java object.
	* @returns booking      - returns booking


	*********************/
	@GetMapping("/getbycustomer/{customerId}")
	public List<Booking> getBookingsByCustomer(@PathVariable String customerId) {
		List<Booking> booking1 = this.iBookingService.getBookingsByCustomer(customerId);
		return booking1;
	}
}
