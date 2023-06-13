package com.ReservationService.service;

import com.ReservationService.DTO.ReservationDTO;
import com.ReservationService.mapper.ReservationMapper;
import com.ReservationService.model.Reservation;
import com.ReservationService.model.enums.Status;
import com.ReservationService.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public Reservation create(ReservationDTO reservationDTO){
        Reservation reservation = reservationMapper.DtoToEntity(reservationDTO);
        reservationRepository.save(reservation);
        return reservation;
    }

    public List<ReservationDTO> getAllByUser(String id){
        Optional<List<Reservation>> reservations = reservationRepository.findAllByGuestId(id);
        List<Reservation> approvedReservations = new ArrayList<>();
        if(!reservations.isEmpty()){
            for (Reservation reservation: reservations.get()) {
                if(reservation.getStatus().equals(Status.RESERVED)){
                    approvedReservations.add(reservation);
                }
            }
        }
        return reservationMapper.ListToDto(approvedReservations);
    }

    public Boolean delete(String id){
        Optional<Reservation> reservation = reservationRepository.findById(id);
        LocalDateTime today = LocalDateTime.now();
            /*if(today.isBefore(reservation.get().getCheckIn().minusDays(1).atStartOfDay())){
                //reservationRepository.delete(reservation.get());
                return true;
            }
        }*/
        if(reservation.isPresent()){
            reservationRepository.delete(reservation.get());
            return true;
        }
        return false;
    }
}
