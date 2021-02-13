package com.smarthost.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Class representing Booking results")
public class BookingResults {

    @ApiModelProperty(position = 4)
    private int economyRoomsUsage;

    @ApiModelProperty(position = 3)
    private int premiumRoomsUsage;

    @ApiModelProperty(position = 2)
    private int economyRoomsIncome;

    @ApiModelProperty(position = 1)
    private int premiumRoomsIncome;

    public BookingResults(final int premiumRoomsIncome,
                          final int economyRoomsIncome,
                          final int premiumRoomsUsage,
                          final int economyRoomsUsage) {
        this.premiumRoomsIncome = premiumRoomsIncome;
        this.economyRoomsIncome = economyRoomsIncome;
        this.premiumRoomsUsage = premiumRoomsUsage;
        this.economyRoomsUsage = economyRoomsUsage;
    }

    public int getEconomyRoomsUsage() {
        return economyRoomsUsage;
    }

    public int getPremiumRoomsUsage() {
        return premiumRoomsUsage;
    }

    public int getEconomyRoomsIncome() {
        return economyRoomsIncome;
    }

    public int getPremiumRoomsIncome() {
        return premiumRoomsIncome;
    }

}
