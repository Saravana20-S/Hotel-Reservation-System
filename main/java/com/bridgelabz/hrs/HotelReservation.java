package com.bridgelabz.hrs;

import com.bridgelabz.hrs.model.Hotel;

/**
 * Entry point of Hotel Reservation System.
 */
public class HotelReservation {

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");

        // Creating hotel objects
        Hotel lakewood = new Hotel("Lakewood", 110, 90);
        Hotel bridgewood = new Hotel("Bridgewood", 160, 60);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 150);

        // Display hotel details
        System.out.println("Hotel: " + lakewood.getHotelName());
        System.out.println("Hotel: " + bridgewood.getHotelName());
        System.out.println("Hotel: " + ridgewood.getHotelName());
    }
}