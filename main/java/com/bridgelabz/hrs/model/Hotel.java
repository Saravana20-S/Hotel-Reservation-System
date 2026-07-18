package com.bridgelabz.hrs.model;

/**
 * Represents a Hotel with weekday and weekend rates
 * for a Regular customer.
 */
public class Hotel {

    // Hotel name
    private String hotelName;

    // Regular customer weekday rate
    private int weekdayRate;

    // Regular customer weekend rate
    private int weekendRate;

    /**
     * Creates a Hotel object.
     *
     * @param hotelName Hotel name
     * @param weekdayRate Weekday rate
     * @param weekendRate Weekend rate
     */
    public Hotel(String hotelName, int weekdayRate, int weekendRate) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
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
    public int getWeekdayRate() {
        return weekdayRate;
    }

    /**
     * Returns weekend rate.
     *
     * @return weekend rate
     */
    public int getWeekendRate() {
        return weekendRate;
    }
}