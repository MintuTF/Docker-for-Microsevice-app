package edu.miu.cs.flightreservation.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Ticket")
public class Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int number;
    private String reservationCode;
    private LocalDate date;


    public Ticket(){

    }

    public Ticket(int num, String code, LocalDate d) {
        this.number = num;
        this.reservationCode = code;
        this.date = d;

    }
}
