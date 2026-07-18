package com.bridgelabz.hrs;

import com.bridgelabz.hrs.model.Hotel;
import com.bridgelabz.hrs.service.HotelReservationService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for Hotel Reservation System.
 */
public class HotelReservationTest {

    /**
     * Tests whether the cheapest hotel is returned
     * for the given reservation dates.
     */
    @Test
    public void givenDateRange_WhenFindingCheapestHotel_ShouldReturnLakewood() {

        // Arrange
        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90));
        service.addHotel(new Hotel("Bridgewood", 160, 60));
        service.addHotel(new Hotel("Ridgewood", 220, 150));

        // Act
        String result = service.findCheapestHotel(
                LocalDate.of(2020, 9, 10),
                LocalDate.of(2020, 9, 11)
        );

        // Assert
        assertEquals("Lakewood, Total Rates: $220", result);
    }
}