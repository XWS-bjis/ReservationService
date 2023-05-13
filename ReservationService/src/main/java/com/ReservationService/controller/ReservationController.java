package com.ReservationService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    @GetMapping("/part1")
    public ResponseEntity<String> proba(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/part2")
    public ResponseEntity<String> proba2(){
        return new ResponseEntity<>("hello drugi put", HttpStatus.OK);
    }
}
