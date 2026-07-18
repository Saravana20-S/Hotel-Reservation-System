package com.bridgelabz.hrs.exception;

/**
 * Custom exception for Hotel Reservation System.
 */
public class HotelReservationException extends RuntimeException {

    /**
     * Exception types.
     */
    public enum ExceptionType {
        INVALID_CUSTOMER_TYPE,
        INVALID_DATE_RANGE
    }

    private final ExceptionType type;

    /**
     * Creates a custom exception.
     *
     * @param type Exception type
     * @param message Exception message
     */
    public HotelReservationException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public ExceptionType getType() {
        return type;
    }
}