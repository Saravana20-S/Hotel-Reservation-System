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
     * Finds the cheapest hotel for the given reservation dates.
     * If multiple hotels have the same minimum cost,
     * all of them are returned.
     *
     * @param dates Reservation dates
     * @return Cheapest hotel(s) with total cost
     */
    public String findCheapestHotel(LocalDate... dates) {

        int minimumCost = Integer.MAX_VALUE;
        List<String> cheapestHotels = new ArrayList<>();

        // Iterate through every hotel
        for (Hotel hotel : hotelList) {

            int totalCost = 0;

            // Calculate total cost for the given dates
            for (LocalDate date : dates) {

                DayOfWeek day = date.getDayOfWeek();

                // Weekend
                if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                    totalCost += hotel.getWeekendRate();
                }
                // Weekday
                else {
                    totalCost += hotel.getWeekdayRate();
                }
            }

            // Found a cheaper hotel
            if (totalCost < minimumCost) {

                minimumCost = totalCost;
                cheapestHotels.clear();
                cheapestHotels.add(hotel.getHotelName());

            }
            // Same minimum cost
            else if (totalCost == minimumCost) {

                cheapestHotels.add(hotel.getHotelName());

            }
        }

        return String.join(" and ", cheapestHotels)
                + ", Total Rates: $" + minimumCost;
    }
}