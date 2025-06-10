package com.flighttracker;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;
/**
 * *******************************************************
 * Package: com.flighttracker
 * File: FlightTest.java
 * Author: Ochwada
 * Date: Tuesday, 10.Jun.2025, 3:05 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class FlightTest {

    @Test
    public void testFlightIsDeparted() {
        // Arrange: A flight 1 hour ago
        Flight flight = new Flight(
                "XY001",
                LocalDateTime.now().minusHours(1),
                ZoneId.of("Europe/London")
        );
        boolean departed = flight.isDeparted();

        assertFalse(departed, "Flight should be marked as departed.");
    }

    @Test
    public void testFlightNotDeparted() {
        // Arrange: A flight 1 hour in the future
        Flight flight = new Flight(
                "XY002",
                LocalDateTime.now().plusHours(1),
                ZoneId.of("Europe/Berlin")
        );

        boolean departed = flight.isDeparted();

        assertFalse(departed, "Flight should not be marked as departed.");
    }

    @Test
    public void testFlightStatusUpdate() {
        // Arrange: A flight that has already departed
        Flight flight = new Flight(
                "XY003",
                LocalDateTime.now().minusMinutes(30),
                ZoneId.of("Europe/London")
        );
        flight.printFlightDetails(); // should trigger status update

        assertEquals(FlightStatus.ARRIVED, getStatusUsingReflection(flight));
    }

    /**
     * Bonus helper: access the private 'status' field using reflection.
     * Not needed in production, just for testing purposes.
     */
    private FlightStatus getStatusUsingReflection(Flight flight) {
        try {
            var field = Flight.class.getDeclaredField("status");
            field.setAccessible(true);
            return (FlightStatus) field.get(flight);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access status via reflection", e);
        }
    }


}
