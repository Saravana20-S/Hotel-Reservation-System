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

        // Add hotels with regular rates, reward rates and rating
        service.addHotel(new Hotel(
                "Lakewood",
                110,
                90,
                80,
                80,
                3));

        service.addHotel(new Hotel(
                "Bridgewood",
                150,
                50,
                110,
                50,
                4));

        service.addHotel(new Hotel(
                "Ridgewood",
                220,
                150,
                100,
                40,
                5));
        String result = service.findBestRatedHotel(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        System.out.println(result);
    }
}