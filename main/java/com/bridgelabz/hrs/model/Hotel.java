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

    // Reward customer weekday rate
    private int rewardWeekdayRate;

    // Reward customer weekend rate
    private int rewardWeekendRate;


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
     * Creates a Hotel object.
     *
     * @param hotelName Hotel name
     * @param weekdayRate Regular weekday rate
     * @param weekendRate Regular weekend rate
     * @param rewardWeekdayRate Reward weekday rate
     * @param rewardWeekendRate Reward weekend rate
     * @param rating Hotel rating
     */
    public Hotel(String hotelName,
                 int weekdayRate,
                 int weekendRate,
                 int rewardWeekdayRate,
                 int rewardWeekendRate,
                 int rating) {

        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rewardWeekdayRate = rewardWeekdayRate;
        this.rewardWeekendRate = rewardWeekendRate;
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


    /**
     * Returns reward customer weekday rate.
     *
     * @return reward weekday rate
     */
    public int getRewardWeekdayRate() {
        return rewardWeekdayRate;
    }

    /**
     * Returns reward customer weekend rate.
     *
     * @return reward weekend rate
     */
    public int getRewardWeekendRate() {
        return rewardWeekendRate;
    }
}