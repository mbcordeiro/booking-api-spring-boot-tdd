package com.matheuscordeiro.bookingapi.controller;

import com.matheuscordeiro.bookingapi.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @GetMapping
    @ResponseBody
    public String getAll() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<Booking> save(Booking booking) {
        return ResponseEntity.ok().body(booking);
    }
}
