package com.smarthost.challenge.service;

import com.smarthost.challenge.model.BookingResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

@Component
public class BookingService {

    private static final int THRESHOLD = 100;

    private List<Integer> bids;

    public BookingService(@Autowired @Qualifier("getBids") List<Integer> getBids) {
        this.bids = getBids;
    }

    public ResponseEntity<BookingResults> bookingForecast(final int availablePremiumRooms,
                                                          final int availableEconomyRooms) {
        assert availablePremiumRooms >= 0;
        assert availableEconomyRooms >= 0;

        final Map<Boolean, List<Integer>> parts = bids.stream().collect(partitioningBy(bid -> bid >= THRESHOLD));
        final List<Integer> premiumBids = parts.get(true);
        final List<Integer> economyBids = parts.get(false);

        final int premiumRoomsUsage = Math.min(availablePremiumRooms, premiumBids.size());
        final int premiumRoomsIncome = premiumBids.stream().limit(premiumRoomsUsage).mapToInt(Integer::intValue).sum();
        final int premiumRoomsLeft = Math.max(availablePremiumRooms - premiumRoomsUsage, 0);

        final int economyRoomsShortage = Math.max(economyBids.size() - availableEconomyRooms, 0);
        final int upgradedRoomsUsage = Math.min(premiumRoomsLeft, economyRoomsShortage);
        final int upgradedRoomsIncome = economyBids.stream().limit(upgradedRoomsUsage).mapToInt(Integer::intValue).sum();

        final int economyRoomsUsage = Math.min(economyBids.size() - upgradedRoomsUsage, availableEconomyRooms);
        final int economyRoomsIncome = economyBids.stream().skip(upgradedRoomsUsage).limit(economyRoomsUsage).mapToInt(Integer::intValue).sum();

        return new ResponseEntity<>(new BookingResults(premiumRoomsUsage + upgradedRoomsUsage, economyRoomsUsage,
                premiumRoomsIncome + upgradedRoomsIncome, economyRoomsIncome), HttpStatus.OK);
    }

}
