package com.bridgelabz.hrs.service;

import com.bridgelabz.hrs.exception.HotelReservationException;
import com.bridgelabz.hrs.model.CustomerType;
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
     * Calculates the total reservation cost.
     *
     * @param hotel Hotel
     * @param customerType Customer type
     * @param dates Reservation dates
     * @return Total cost
     */
    private int calculateTotalCost(Hotel hotel,
                                   CustomerType customerType,
                                   LocalDate... dates) {

        return java.util.Arrays.stream(dates)

                .mapToInt(date -> {

                    boolean isWeekend =
                            date.getDayOfWeek() == DayOfWeek.SATURDAY
                                    || date.getDayOfWeek() == DayOfWeek.SUNDAY;

                    if (customerType == CustomerType.REWARD) {

                        return isWeekend
                                ? hotel.getRewardWeekendRate()
                                : hotel.getRewardWeekdayRate();
                    }

                    return isWeekend
                            ? hotel.getWeekendRate()
                            : hotel.getWeekdayRate();
                })

                .sum();
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


    /**
     * Finds the cheapest best-rated hotel for the given customer type
     * using Java Streams.
     *
     * @param customerType Customer type
     * @param dates Reservation dates
     * @return Cheapest best-rated hotel
     */
    public String findCheapestBestRatedHotel(CustomerType customerType,
                                             LocalDate... dates) {

        // Validate customer type
        if (customerType == null) {
            throw new HotelReservationException(
                    HotelReservationException.ExceptionType.INVALID_CUSTOMER_TYPE,
                    "Customer type cannot be null.");
        }

        // Validate date range
        if (dates == null || dates.length == 0) {
            throw new HotelReservationException(
                    HotelReservationException.ExceptionType.INVALID_DATE_RANGE,
                    "Please provide at least one reservation date.");
        }

        Hotel cheapestHotel = hotelList.stream()

                // Compare total cost
                .min((hotel1, hotel2) -> {

                    int hotel1Cost = calculateTotalCost(hotel1, customerType, dates);
                    int hotel2Cost = calculateTotalCost(hotel2, customerType, dates);

                    if (hotel1Cost == hotel2Cost) {
                        // If costs are equal, compare ratings
                        return Integer.compare(
                                hotel2.getRating(),
                                hotel1.getRating());
                    }

                    return Integer.compare(hotel1Cost, hotel2Cost);
                })

                .orElseThrow(() ->
                        new HotelReservationException(
                                HotelReservationException.ExceptionType.INVALID_DATE_RANGE,
                                "No hotels available."));

        int totalCost = calculateTotalCost(cheapestHotel, customerType, dates);

        return cheapestHotel.getHotelName()
                + ", Rating: "
                + cheapestHotel.getRating()
                + " and Total Rates: $"
                + totalCost;
    }


    /**
     * Validates the customer type.
     *
     * @param customerType Customer type
     */
    private void validateCustomerType(String customerType) {

        if (customerType == null ||
                !customerType.matches("^(REGULAR|REWARD)$")) {

            throw new HotelReservationException(
                    HotelReservationException.ExceptionType.INVALID_CUSTOMER_TYPE,
                    "Invalid customer type.");
        }
    }
}