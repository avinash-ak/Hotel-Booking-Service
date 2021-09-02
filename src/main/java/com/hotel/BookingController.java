package com.hotel;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookingController {
	private List<HotelBooking>bookings;
	
	public BookingController() {
		bookings=new ArrayList<>();
		bookings.add(new HotelBooking("Empire",200.50,3));
		bookings.add(new HotelBooking("Plaza",20.5,5));
		bookings.add(new HotelBooking("Taj",80.50,1));
	}
	
	//Adding the reference to the repository for the controller
	BookingRepository bookingrepository;
	
	@Autowired
	public BookingController(BookingRepository bookingrepository) {
		this.bookingrepository=bookingrepository;
	}
	
	@GetMapping("/all")
	public List<HotelBooking> getBookings(){
		return bookings;
//		return bookingrepository.findAll();
	}
	
	@GetMapping("/affordable/{price}")
	public List<HotelBooking>getAffordable(@PathVariable double price){
		return bookings.stream().filter(x->x.getPricePerNight()<=price).collect(Collectors.toList());
//		return bookingrepository.findByPricePerNightLessThan(price);
	}
	
	@GetMapping("/package/{price}")
	public List<HotelBooking>findAffordablePackage(@PathVariable double price){
		return bookings.stream().filter(x->x.getTotalPrice()<=price).collect(Collectors.toList());
		
	}
	
	@PostMapping("/new")
	public List<HotelBooking>addHotel(@RequestBody HotelBooking hotelbooking){
		bookings.add(hotelbooking);
		return bookings;
//		bookingrepository.save(hotelbooking);
//		return bookingrepository.findAll();
	}
	
	@GetMapping("/delete/{id}")
	public List<HotelBooking>remove(@PathVariable HotelBooking id){
		bookingrepository.delete(id);
		return bookingrepository.findAll();
	}
}
