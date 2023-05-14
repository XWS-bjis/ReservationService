package com.ReservationService.model;

import com.ReservationService.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Reservation {
    @Id
    private String id;
    @Field
    private String accommodationId;
    @Field
    private String guestId;
    @Field
    private LocalDate checkIn;
    @Field
    private LocalDate checkOut;
    @Field
    private Integer guestNumber;
    @Field
    private double totalPrice;
    @Field
    private Status status;
}
