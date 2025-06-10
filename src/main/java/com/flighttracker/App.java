package com.flighttracker;
import java.time.LocalDateTime;
import java.time.ZoneId;
/**
 * Demo Class
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Flight flight = new Flight(
                "XY123",
                LocalDateTime.of(2025, 6, 9, 17, 0),
                ZoneId.of("Europe/London")
        );

        flight.printFlightDetails();
    }
}
