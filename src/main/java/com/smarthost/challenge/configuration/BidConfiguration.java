package com.smarthost.challenge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Configuration
public class BidConfiguration {

    @Bean
    public List<Integer> getBids(){
        final List<Integer> bids = Arrays.asList(new Integer[]{23, 45, 155, 374, 22, 99, 100, 101, 115, 209});
        bids.sort(Comparator.comparingInt(b -> -b));
        return bids;
    }
}
