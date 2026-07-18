package com.bridgelabz.hrs;

import com.bridgelabz.hrs.exception.HotelReservationException;
import com.bridgelabz.hrs.model.CustomerType;
import com.bridgelabz.hrs.model.Hotel;
import com.bridgelabz.hrs.service.HotelReservationService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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


    /**
     * Tests whether the cheapest hotel with the
     * highest rating is returned when costs are equal.
     */
    @Test
    public void givenDateRange_WhenHotelsHaveSameCost_ShouldReturnHighestRatedHotel() {

        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        String result = service.findCheapestHotel(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        assertEquals(
                "Bridgewood, Rating: 4 and Total Rates: $200",
                result
        );
    }


    /**
     * Tests whether the highest rated hotel is returned.
     */
    @Test
    public void givenDateRange_WhenFindingBestRatedHotel_ShouldReturnRidgewood() {

        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        String result = service.findBestRatedHotel(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12)
        );

        assertEquals("Ridgewood, Rating: 5", result);
    }

    /**
     * Tests whether reward customer rates
     * are stored correctly.
     */
    @Test
    public void givenRewardRates_WhenHotelCreated_ShouldReturnRewardRates() {

        Hotel hotel = new Hotel(
                "Lakewood",
                110,
                90,
                80,
                80,
                3);

        assertEquals(80, hotel.getRewardWeekdayRate());
        assertEquals(80, hotel.getRewardWeekendRate());
    }


//UC10
    @Test
    public void givenRewardCustomer_WhenFindingCheapestHotel_ShouldReturnRidgewood() {

        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood",110,90,80,80,3));
        service.addHotel(new Hotel("Bridgewood",150,50,110,50,4));
        service.addHotel(new Hotel("Ridgewood",220,150,100,40,5));

        String result = service.findCheapestBestRatedHotel(
                CustomerType.REWARD,
                LocalDate.of(2020,9,11),
                LocalDate.of(2020,9,12));

        assertEquals(
                "Ridgewood, Rating: 5 and Total Rates: $140",
                result);
    }


    @Test
    public void givenNullCustomerType_ShouldThrowException() {

        HotelReservationService service = new HotelReservationService();

        assertThrows(
                HotelReservationException.class,
                () -> service.findCheapestBestRatedHotel(
                        null,
                        LocalDate.of(2020,9,11))
        );
    }


    @Test
    public void givenNoDates_ShouldThrowException() {

        HotelReservationService service = new HotelReservationService();

        assertThrows(
                HotelReservationException.class,
                () -> service.findCheapestBestRatedHotel(
                        CustomerType.REWARD)
        );
    }


    //UC11
    @Test
    public void givenRewardCustomer_WhenFindingCheapestBestRatedHotel_ShouldReturnRidgewood() {

        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood",110,90,80,80,3));
        service.addHotel(new Hotel("Bridgewood",150,50,110,50,4));
        service.addHotel(new Hotel("Ridgewood",220,150,100,40,5));

        String result = service.findCheapestBestRatedHotel(
                CustomerType.REWARD,
                LocalDate.of(2020,9,11),
                LocalDate.of(2020,9,12));

        assertEquals(
                "Ridgewood, Rating: 5 and Total Rates: $140",
                result);
    }
}