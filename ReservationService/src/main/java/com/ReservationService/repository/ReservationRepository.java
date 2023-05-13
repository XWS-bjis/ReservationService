package com.ReservationService.repository;

import com.ReservationService.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends MongoRepository<Reservation, String> {

    Optional<List<Reservation>> findAllByGuestId(String guestId);
    Optional<Reservation> findById(String id);
}
