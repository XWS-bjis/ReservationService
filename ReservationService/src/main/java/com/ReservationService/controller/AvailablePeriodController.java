package com.ReservationService.controller;

import com.ReservationService.model.AvailablePeriod;
import com.ReservationService.service.AvailablePeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/available-period")
@CrossOrigin(origins = "http://localhost:4200")
public class AvailablePeriodController {

    @Autowired
    private AvailablePeriodService availablePeriodService;

    @PostMapping
    public ResponseEntity create(@RequestBody AvailablePeriod availablePeriod) {
        boolean success = availablePeriodService.create(availablePeriod);
        if (success) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @PutMapping
    public ResponseEntity edit(@RequestBody AvailablePeriod availablePeriod) {
        boolean success = availablePeriodService.edit(availablePeriod);
        if (success) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @GetMapping("/accommodation/{id}")
    public ResponseEntity<List<AvailablePeriod>> getAllByAccommodation(@PathVariable String id) {
        return new ResponseEntity<>(availablePeriodService.getAllByAccommodation(id), HttpStatus.OK);
    }
}
