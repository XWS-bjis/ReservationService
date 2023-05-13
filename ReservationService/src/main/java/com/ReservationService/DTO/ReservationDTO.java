package com.ReservationService.DTO;

import com.ReservationService.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private String accommodationId;
    private String guestId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer guestNumber;
    private double totalPrice;
    private Status status;
}
