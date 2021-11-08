package com.matheuscordeiro.bookingapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheuscordeiro.bookingapi.model.Booking;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnGetAllBookings() throws Exception {
        mockMvc.perform(get("/api/bookings")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnSaveBooking() throws Exception {
        var checkIn = LocalDate.parse("2021-11-07");
        var checkOut = LocalDate.parse("2021-11-17");
        var booking = Booking.builder()
                .id(1L)
                .reserveName("Matheus")
                .checkIn(checkIn)
                .checkOut(checkOut)
                .numberGuests(2)
                .build();
        mockMvc.perform(
                post("/api/bookings")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(booking))
        ).andExpect(status().isOk());
    }
}
