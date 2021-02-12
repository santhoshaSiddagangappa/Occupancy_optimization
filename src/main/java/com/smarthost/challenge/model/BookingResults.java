package com.smarthost.challenge.model;

public class BookingResults {

    private int economyRoomsUsage;
    private int premiumRoomsUsage;
    private int economyRoomsIncome;
    private int premiumRoomsIncome;

    BookingResults(final int economyRoomsUsage,
                          final int premiumRoomsUsage,
                          final int economyRoomsIncome,
                          final int premiumRoomsIncome) {
        this.economyRoomsUsage = economyRoomsUsage;
        this.premiumRoomsUsage = premiumRoomsUsage;
        this.economyRoomsIncome = economyRoomsIncome;
        this.premiumRoomsIncome = premiumRoomsIncome;
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
