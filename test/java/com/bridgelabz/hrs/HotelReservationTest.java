package com.bridgelabz.hrs;

import com.bridgelabz.hrs.model.Hotel;
import com.bridgelabz.hrs.service.HotelReservationService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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

    /**
     * Tests whether multiple hotels are returned
     * when they have the same minimum cost.
     */
    @Test
    public void givenWeekdayAndWeekendDates_WhenRatesAreEqual_ShouldReturnBothHotels() {

        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90));
        service.addHotel(new Hotel("Bridgewood", 150, 50));
        service.addHotel(new Hotel("Ridgewood", 220, 150));

        String result = service.findCheapestHotel(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        assertEquals(
                "Lakewood and Bridgewood, Total Rates: $200",
                result
        );
    }

    /**
     * Tests whether the hotel rating is stored correctly.
     */
    @Test
    public void givenHotelRating_WhenHotelCreated_ShouldReturnCorrectRating() {

        Hotel hotel = new Hotel("Lakewood", 110, 90, 3);

        assertEquals("Lakewood", hotel.getHotelName());
        assertEquals(110, hotel.getWeekdayRate());
        assertEquals(90, hotel.getWeekendRate());
        assertEquals(3, hotel.getRating());
    }
}