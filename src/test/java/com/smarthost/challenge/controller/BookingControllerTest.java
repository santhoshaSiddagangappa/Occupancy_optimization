package com.smarthost.challenge.controller;

import com.smarthost.challenge.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BookingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void bookingForecast() throws Exception {
        mockMvc.perform(
                get("/booking-forecast")
                        .param("availablePremiumRooms", "3")
                        .param("availableEconomyRooms", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.premiumRooms", is(3)))
                .andExpect(jsonPath("$.economyRooms", is(3)))
                .andExpect(jsonPath("$.premiumRoomsUsage", is(738)))
                .andExpect(jsonPath("$.economyRoomsUsage", is(167)));
    }

    @Test
    public void bookingForecast_premiumBidsLack() throws Exception {
        mockMvc.perform(
                get("/booking-forecast")
                        .param("availablePremiumRooms", "7")
                        .param("availableEconomyRooms", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.premiumRooms", is(6)))
                .andExpect(jsonPath("$.economyRooms", is(4)))
                .andExpect(jsonPath("$.premiumRoomsUsage", is(1054)))
                .andExpect(jsonPath("$.economyRoomsUsage", is(189)));
    }

    @Test
    public void bookingForecast_economyBidsLack() throws Exception {
        mockMvc.perform(
                get("/booking-forecast")
                        .param("availablePremiumRooms", "2")
                        .param("availableEconomyRooms", "7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.premiumRooms", is(2)))
                .andExpect(jsonPath("$.economyRooms", is(4)))
                .andExpect(jsonPath("$.premiumRoomsUsage", is(583)))
                .andExpect(jsonPath("$.economyRoomsUsage", is(189)));
    }

    @Test
    public void bookingForecast_premiumBidsLack_1() throws Exception {
        mockMvc.perform(
                get("/booking-forecast")
                        .param("availablePremiumRooms", "7")
                        .param("availableEconomyRooms", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.premiumRooms", is(7)))
                .andExpect(jsonPath("$.economyRooms", is(1)))
                .andExpect(jsonPath("$.premiumRoomsUsage", is(1153)))
                .andExpect(jsonPath("$.economyRoomsUsage", is(45)));
    }

}
