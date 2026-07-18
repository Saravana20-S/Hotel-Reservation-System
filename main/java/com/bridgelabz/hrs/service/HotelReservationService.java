package com.bridgelabz.hrs.service;

import com.bridgelabz.hrs.model.Hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for Hotel Reservation operations.
 */
public class HotelReservationService {

    // Stores all hotels
    private final List<Hotel> hotelList = new ArrayList<>();

    /**
     * Adds a hotel to the reservation system.
     *
     * @param hotel Hotel object
     */
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }

    /**
     * Finds the cheapest hotel for the given dates.
     *
     * @param dates Reservation dates
     * @return Cheapest hotel with total cost
     */
    public String findCheapestHotel(LocalDate... dates) {

        Hotel cheapestHotel = null;
        int minimumCost = Integer.MAX_VALUE;

        // Calculate total cost for every hotel
        for (Hotel hotel : hotelList) {

            int totalCost = 0;

            for (LocalDate date : dates) {

                // Check whether the date is weekend
                if (date.getDayOfWeek() == DayOfWeek.SATURDAY
                        || date.getDayOfWeek() == DayOfWeek.SUNDAY) {

                    totalCost += hotel.getWeekendRate();

                } else {

                    totalCost += hotel.getWeekdayRate();

                }
            }

            // Update cheapest hotel
            if (totalCost < minimumCost) {
                minimumCost = totalCost;
                cheapestHotel = hotel;
            }
        }

        return cheapestHotel.getHotelName() + ", Total Rates: $" + minimumCost;
    }
}