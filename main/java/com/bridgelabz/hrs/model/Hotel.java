package com.bridgelabz.hrs.model;

/**
 * Represents a Hotel with its name and
 * rates for Regular customers.
 */
public class Hotel {

    // Hotel name
    private String hotelName;

    // Weekday rate for Regular customer
    private int regularWeekdayRate;

    // Weekend rate for Regular customer
    private int regularWeekendRate;

    /**
     * Parameterized constructor to initialize hotel details.
     *
     * @param hotelName Name of the hotel
     * @param regularWeekdayRate Weekday rate for Regular customer
     * @param regularWeekendRate Weekend rate for Regular customer
     */
    public Hotel(String hotelName, int regularWeekdayRate, int regularWeekendRate) {
        this.hotelName = hotelName;
        this.regularWeekdayRate = regularWeekdayRate;
        this.regularWeekendRate = regularWeekendRate;
    }

    /**
     * Returns hotel name.
     *
     * @return hotel name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Returns weekday rate.
     *
     * @return weekday rate
     */
    public int getRegularWeekdayRate() {
        return regularWeekdayRate;
    }

    /**
     * Returns weekend rate.
     *
     * @return weekend rate
     */
    public int getRegularWeekendRate() {
        return regularWeekendRate;
    }
}