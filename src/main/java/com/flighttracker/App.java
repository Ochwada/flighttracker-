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
        Flight flight1 = new Flight(
                "XY123",
                LocalDateTime.of(2025, 6, 9, 17, 0),
                ZoneId.of("Europe/London")
        );

        Flight flight2 = new Flight(
                "LH456",
                LocalDateTime.of(2025, 6, 10, 9, 30),
                ZoneId.of("Europe/Berlin")
        );

        Flight flight3 = new Flight(
                "EK202",
                LocalDateTime.of(2025, 6, 11, 23, 45),
                ZoneId.of("Asia/Dubai")
        );
        Flight flight4 = new Flight(
                "AF102",
                LocalDateTime.now().minusHours(1), // already departed
                ZoneId.of("Europe/Paris")
        );




        flight1.printFlightDetails();
        System.out.println();
        flight2.printFlightDetails();
        System.out.println();
        flight3.printFlightDetails();
        System.out.println();
        flight4.printFlightDetails();
    }
}
