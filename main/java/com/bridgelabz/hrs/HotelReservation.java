package com.bridgelabz.hrs;

import com.bridgelabz.hrs.model.CustomerType;
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

        // Add hotels with regular rates, reward rates and rating
        String result = service.findCheapestBestRatedHotel(
                CustomerType.REGULAR,
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        System.out.println(result);

    }
}