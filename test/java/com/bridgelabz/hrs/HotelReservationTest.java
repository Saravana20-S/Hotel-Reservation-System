package com.bridgelabz.hrs;

import com.bridgelabz.hrs.model.Hotel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Hotel.
 */
public class HotelReservationTest {

    /**
     * Tests whether hotel rates are stored correctly.
     */
    @Test
    public void givenHotelRates_WhenHotelCreated_ShouldReturnCorrectRates() {

        Hotel hotel = new Hotel("Lakewood", 110, 90);

        assertEquals("Lakewood", hotel.getHotelName());
        assertEquals(110, hotel.getWeekdayRate());
        assertEquals(90, hotel.getWeekendRate());
    }
}