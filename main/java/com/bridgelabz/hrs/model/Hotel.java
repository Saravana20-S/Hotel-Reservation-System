package com.bridgelabz.hrs.model;

/**
 * Represents a Hotel with weekday/weekend rates
 * and its rating.
 */
public class Hotel {

    // Hotel name
    private String hotelName;

    // Weekday rate for Regular customer
    private int weekdayRate;

    // Weekend rate for Regular customer
    private int weekendRate;

    // Hotel rating
    private int rating;


    public Hotel(String hotelName, int weekdayRate, int weekendRate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }


    /**
     * Creates a Hotel object.
     *
     * @param hotelName Hotel name
     * @param weekdayRate Weekday rate
     * @param weekendRate Weekend rate
     * @param rating Hotel rating
     */
    public Hotel(String hotelName, int weekdayRate, int weekendRate, int rating) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
    }

    /**
     * Returns the hotel name.
     *
     * @return hotel name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Returns the weekday rate.
     *
     * @return weekday rate
     */
    public int getWeekdayRate() {
        return weekdayRate;
    }

    /**
     * Returns the weekend rate.
     *
     * @return weekend rate
     */
    public int getWeekendRate() {
        return weekendRate;
    }

    /**
     * Returns the hotel rating.
     *
     * @return hotel rating
     */
    public int getRating() {
        return rating;
    }
}