package com.ReservationService.repository;

import com.ReservationService.model.AvailablePeriod;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvailablePeriodRepository extends MongoRepository<AvailablePeriod, String> {

    List<AvailablePeriod> findByAccommodationId(String accommodationId);
}
