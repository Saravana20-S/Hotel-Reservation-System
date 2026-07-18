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
     * If multiple hotels have the same total cost,
     * the hotel with the highest rating is returned.
     *
     * @param dates Reservation dates
     * @return Cheapest best-rated hotel with rating and total cost
     */
    public String findCheapestHotel(LocalDate... dates) {

        Hotel cheapestHotel = null;
        int minimumCost = Integer.MAX_VALUE;

        // Iterate through every hotel
        for (Hotel hotel : hotelList) {

            int totalCost = 0;

            // Calculate total cost
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
                cheapestHotel = hotel;
            }

            // If cost is same, choose hotel with higher rating
            else if (totalCost == minimumCost &&
                    hotel.getRating() > cheapestHotel.getRating()) {

                cheapestHotel = hotel;
            }
        }

        return cheapestHotel.getHotelName()
                + ", Rating: "
                + cheapestHotel.getRating()
                + " and Total Rates: $"
                + minimumCost;
    }


    /**
     * Finds the highest rated hotel.
     * The dates are accepted as input to satisfy the use case,
     * but only the hotel rating is considered.
     *
     * @param dates Reservation dates
     * @return Best rated hotel
     */
    public String findBestRatedHotel(LocalDate... dates) {

        Hotel bestRatedHotel = null;

        // Iterate through all hotels
        for (Hotel hotel : hotelList) {

            // Select hotel with highest rating
            if (bestRatedHotel == null ||
                    hotel.getRating() > bestRatedHotel.getRating()) {

                bestRatedHotel = hotel;
            }
        }

        return bestRatedHotel.getHotelName()
                + ", Rating: "
                + bestRatedHotel.getRating();
    }
}