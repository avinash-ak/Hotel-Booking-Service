package com.hotel;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DatabaseSeeder implements CommandLineRunner {

	//CommandLineRunner helps to run the code within it as soon as application context starts
	//you can order the commandlinerunner in which you want to execute with the help of @order
	private BookingRepository bookingrepository;
	
	@Autowired
	public DatabaseSeeder(BookingRepository bookinrepository) {
		this.bookingrepository=bookingrepository;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		List<HotelBooking>bookings=new ArrayList<>();
		
		bookings.add(new HotelBooking("Empire",200.5,5));
		bookings.add(new HotelBooking("Marriot",200.5,5));
		bookings.add(new HotelBooking("MoonLight",200.5,5));
	}

}
