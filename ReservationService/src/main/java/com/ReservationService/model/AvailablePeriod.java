package com.ReservationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class AvailablePeriod {
    @Id
    private String id;
    @Field
    private LocalDate start;
    @Field
    private LocalDate end;
    @Field
    private int price;
    @Field
    private String accommodationId;
    @Field
    private List<Reservation> reservations;
}
