package com.smarthost.challenge.controller;

import com.smarthost.challenge.model.BookingResults;
import com.smarthost.challenge.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/booking-forecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingResults> bookingForeCast(@RequestParam(required = true) int availablePremiumRooms,
                                                          @RequestParam(required = true) int availableEconomyRooms){
        return bookingService.bookingForecast(availablePremiumRooms, availableEconomyRooms);
    }
}
