package com.matheuscordeiro.bookingapi.service;

import com.matheuscordeiro.bookingapi.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public int dayCalculator(String name) {
        var result = bookingRepository.findByReserveName(name);
        return Period.between(result.get().getCheckIn(), result.get().getCheckOut()).getDays();
    }
}
