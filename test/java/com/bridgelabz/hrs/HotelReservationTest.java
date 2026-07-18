package com.bridgelabz.hrs;

import com.bridgelabz.hrs.model.Hotel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for Hotel Reservation System.
 */
public class HotelReservationTest {

    /**
     * Tests whether a hotel is created successfully.
     */
    @Test
    public void givenHotelDetails_WhenHotelCreated_ShouldReturnCorrectValues() {

        // Arrange
        Hotel hotel = new Hotel("Lakewood", 110, 90);

        // Assert
        assertEquals("Lakewood", hotel.getHotelName());
        assertEquals(110, hotel.getRegularWeekdayRate());
        assertEquals(90, hotel.getRegularWeekendRate());
    }
}