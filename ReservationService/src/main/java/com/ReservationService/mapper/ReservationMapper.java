package com.ReservationService.mapper;

import com.ReservationService.DTO.ReservationDTO;
import com.ReservationService.model.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public ReservationDTO EntityToDto(Reservation reservation){
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setAccommodationId(reservation.getAccommodationId());
        dto.setStatus(reservation.getStatus());
        dto.setGuestNumber(reservation.getGuestNumber());
        dto.setGuestId(reservation.getGuestId());
        dto.setTotalPrice(reservation.getTotalPrice());
        dto.setCheckIn(reservation.getCheckIn());
        dto.setCheckOut(reservation.getCheckOut());
        return dto;
    }

    public List<ReservationDTO> ListToDto(List<Reservation> reservations){
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for (Reservation reservation: reservations){
            reservationDTOS.add(EntityToDto(reservation));
        }
        return reservationDTOS;

    }
}
