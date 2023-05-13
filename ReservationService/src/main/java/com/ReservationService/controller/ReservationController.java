package com.ReservationService.controller;

import com.ReservationService.DTO.ReservationDTO;
import com.ReservationService.model.Reservation;
import com.ReservationService.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/part1")
    public ResponseEntity<String> proba(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/part2")
    public ResponseEntity<String> proba2(){
        return new ResponseEntity<>("hello drugi put", HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Reservation> create(@RequestBody ReservationDTO reservationDTO){
        Reservation reservation = reservationService.create(reservationDTO);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Reservation>> allByUser(@PathVariable("id") String id){
        List<Reservation> reservations = reservationService.getAllByUser(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        if(reservationService.delete(id))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
