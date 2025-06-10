package com.flighttracker;


/**
 * *******************************************************
 * Package: com.flighttracker
 * File: FlightStatus.java
 * Author: Ochwada
 * Date: Tuesday, 10.Jun.2025, 12:41 PM
 * Description:
 * Objective:
 * *******************************************************
 */

/**
 * Status of the Flight
 */
public enum FlightStatus {
    SCHEDULED,
    DELAYED,
    DEPARTED,
    ARRIVED;

    public boolean hasArrived() {
        return this == ARRIVED;
    }
}
