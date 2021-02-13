package com.smarthost.challenge.service;

import com.smarthost.challenge.model.BookingResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingService {

    private List<Integer> getBids;

    public BookingService(@Autowired @Qualifier("getBids") List<Integer> getBids) {
        this.getBids = getBids;
    }

    public ResponseEntity<BookingResults> bookingForecast(final int availablePremiumRooms,
                                                          final int availableEconomyRooms) {
        return new ResponseEntity<>(new BookingResults(0, 0,
                0, 0), HttpStatus.OK);
    }

}
