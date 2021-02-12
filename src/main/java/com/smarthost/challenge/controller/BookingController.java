package com.smarthost.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    private List<Integer> getBids;

    public BookingController(@Autowired @Qualifier("getBids") List<Integer> getBids) {
        this.getBids = getBids;
    }
}
