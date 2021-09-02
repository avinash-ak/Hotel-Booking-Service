package com.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<HotelBooking,Integer> {
	List<HotelBooking>findByPricePerNightLessThan(double price);
}
