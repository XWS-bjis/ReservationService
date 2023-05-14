package com.ReservationService.service;

import com.ReservationService.model.AvailablePeriod;
import com.ReservationService.repository.AvailablePeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AvailablePeriodService {
    @Autowired
    private AvailablePeriodRepository availablePeriodRepository;

    public boolean create(AvailablePeriod availablePeriod) {
        if(!isAvailablePeriodValidForAdd(availablePeriod)) {
            return false;
        }
        availablePeriodRepository.save(availablePeriod);
        return true;
    }

    private boolean isAvailablePeriodValidForAdd(AvailablePeriod availablePeriod) {
        List<AvailablePeriod> availablePeriods = availablePeriodRepository.findByAccommodationId(availablePeriod.getAccommodationId());
        for (AvailablePeriod ap: availablePeriods) {
            if (!arePeriodsNotOverlapping(availablePeriod.getStart(), availablePeriod.getEnd(), ap.getStart(), ap.getEnd())) {
                return false;
            }
        }
        return true;
    }

    private boolean arePeriodsNotOverlapping(LocalDate start, LocalDate end, LocalDate start1, LocalDate end1) {
        return (start.isBefore(start1) && end.isBefore(start1)) || (start.isAfter(end1) && end.isAfter(end1));
    }

    public boolean edit(AvailablePeriod availablePeriod) {
        if (availablePeriod.getReservations() != null && availablePeriod.getReservations().size() > 0) return false;
        if(!isAvailablePeriodValidForEdit(availablePeriod)) return false;
        Optional<AvailablePeriod> optionalAvailablePeriod1 = availablePeriodRepository.findById(availablePeriod.getId());
        if (optionalAvailablePeriod1.isEmpty()) return false;
        AvailablePeriod availablePeriod1 = optionalAvailablePeriod1.get();
        availablePeriod1.setPrice(availablePeriod.getPrice());
        availablePeriod1.setStart(availablePeriod.getStart());
        availablePeriod1.setEnd(availablePeriod.getEnd());
        availablePeriodRepository.save(availablePeriod1);
        return true;
    }

    private boolean isAvailablePeriodValidForEdit(AvailablePeriod availablePeriod) {
        List<AvailablePeriod> availablePeriods = availablePeriodRepository.findByAccommodationId(availablePeriod.getAccommodationId());
        for (AvailablePeriod ap: availablePeriods) {
            if (!arePeriodsNotOverlapping(availablePeriod.getStart(), availablePeriod.getEnd(), ap.getStart(), ap.getEnd()) && !availablePeriod.getId().equals(ap.getId())) {
                return false;
            }
        }
        return true;
    }

    public List<AvailablePeriod> getAllByAccommodation(String accommodationId) {
        List<AvailablePeriod> availablePeriods = availablePeriodRepository.findByAccommodationId(accommodationId);
        if (availablePeriods.size() == 0) return null;
        return availablePeriods;
    }
}
