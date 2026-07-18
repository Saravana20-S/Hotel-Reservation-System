package com.bridgelabz.hrs;

import com.bridgelabz.hrs.model.Hotel;
import com.bridgelabz.hrs.service.HotelReservationService;

import java.time.LocalDate;

/**
 * Entry point of Hotel Reservation System.
 */
public class HotelReservation {

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservationService service = new HotelReservationService();

        // Add hotels
        service.addHotel(new Hotel("Lakewood", 110, 90));
        service.addHotel(new Hotel("Bridgewood", 160, 60));
        service.addHotel(new Hotel("Ridgewood", 220, 150));

        // Find cheapest hotel for given dates
        String result = service.findCheapestHotel(
                LocalDate.of(2020, 9, 10),
                LocalDate.of(2020, 9, 11)
        );

        System.out.println(result);
    }
}