package edu.miu.cs.flightreservation.model;

import java.time.LocalDate;

public class Reservation {
    private String reservationCode;
    private LocalDate reservationDate;
    private String departureDeparture;
    private String arrivalPlace;

    public Reservation(String reservationCode, LocalDate reservationDate, String departureDeparture, String arrivalPlace) {
        this.reservationCode = reservationCode;
        this.reservationDate = reservationDate;
        this.departureDeparture = departureDeparture;
        this.arrivalPlace = arrivalPlace;
    }
}
