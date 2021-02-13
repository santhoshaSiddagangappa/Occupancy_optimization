package com.smarthost.challenge.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

@ApiModel(description = "Class representing Booking results")
@ToString
public class BookingResults {

    @ApiModelProperty(position = 1)
    private int premiumRooms;

    @ApiModelProperty(position = 2)
    private int economyRooms;

    @ApiModelProperty(position = 3)
    private int premiumRoomsUsage;

    @ApiModelProperty(position = 4)
    private int economyRoomsUsage;

    public BookingResults(final int premiumRooms,
                          final int economyRooms,
                          final int premiumRoomsUsage,
                          final int economyRoomsUsage) {
        this.premiumRooms = premiumRooms;
        this.economyRooms = economyRooms;
        this.premiumRoomsUsage = premiumRoomsUsage;
        this.economyRoomsUsage = economyRoomsUsage;
    }

    public int getEconomyRoomsUsage() {
        return economyRoomsUsage;
    }

    public int getPremiumRoomsUsage() {
        return premiumRoomsUsage;
    }

    public int getEconomyRooms() {
        return economyRooms;
    }

    public int getPremiumRooms() {
        return premiumRooms;
    }

}
