package com.ReservationService.mapper;

import com.ReservationService.DTO.ReservationDTO;
import com.ReservationService.model.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation DtoToEntity(ReservationDTO reservationDTO){
        Reservation reservation = new Reservation();
        reservation.setStatus(reservationDTO.getStatus());
        reservation.setCheckIn(reservationDTO.getCheckIn());
        reservation.setCheckOut(reservationDTO.getCheckOut());
        reservation.setGuestId(reservationDTO.getGuestId());
        reservation.setAccommodationId(reservationDTO.getAccommodationId());
        reservation.setTotalPrice(reservationDTO.getTotalPrice());
        reservation.setGuestNumber(reservationDTO.getGuestNumber());
        return reservation;
    }
}
