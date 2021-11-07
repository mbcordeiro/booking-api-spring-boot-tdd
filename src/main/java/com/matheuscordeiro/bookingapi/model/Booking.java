package com.matheuscordeiro.bookingapi.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Booking {
    private Long id;
    private String reserveName;
    private LocalDate checkIn;
    private LocalDate checkOut;
}
