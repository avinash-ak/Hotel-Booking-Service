package com.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HotelBooking {
	@Id
	@GeneratedValue
	private int id;
	
	private String hotelName;
	private double pricePerNight;
	private int totalNights;
	
	public HotelBooking() {}
	
	public HotelBooking(String hotelName, double pricePerNight, int totalNights) {
		this.hotelName = hotelName;
		this.pricePerNight = pricePerNight;
		this.totalNights = totalNights;
	}

	public String getHotelName() {
		return hotelName;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public int getTotalNights() {
		return totalNights;
	}
	public double getTotalPrice() {
		return pricePerNight*totalNights;
	}
}
