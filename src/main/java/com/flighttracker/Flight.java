package com.flighttracker;


import java.time.*;

/**
 * *******************************************************
 * Package: com.flighttracker
 * File: Flight.java
 * Author: Ochwada
 * Date: Tuesday, 10.Jun.2025, 12:44 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class Flight {
    private final String flightNumber;
    private final LocalDateTime departureTime;
    private final ZoneId departureZone;
    private FlightStatus status;

    public Flight(String flightNumber, LocalDateTime departureTime, ZoneId departureZone) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.departureZone = departureZone;
        this.status = FlightStatus.ARRIVED;
    }

    /**
     * Checks if the flight has already departed based on the current time in the departure zone.
     *
     * @return true if the current time is after the scheduled departure time
     */
    public boolean isDeparted() {
        ZonedDateTime now = ZonedDateTime.now(departureZone);
        ZonedDateTime departureZoned = departureTime.atZone(departureZone);

        return now.isAfter(departureZoned);
    }


    /**
     * Prints the flight details in a readable format.
     * Also updates the status to DEPARTED if the flight has left (bonus).
     */
    public void printFlightDetails() {
        if (isDeparted() && status == FlightStatus.SCHEDULED) {
            status = FlightStatus.DEPARTED; // Bonus: Update status
        }

        System.out.println("Flight: " + flightNumber);
        System.out.println("Departs at: " + departureTime + " " + departureZone);
        System.out.println("Status: " + status);
    }
}
