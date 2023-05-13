package com.ReservationService.model;

import com.ReservationService.model.enums.Status;

import java.time.LocalDate;

public class Reservation {
    private Long id;
    private Long accommodationId;
    private Long guestId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer guestNumber;
    private double totalPrice;
    private Status status;
}
