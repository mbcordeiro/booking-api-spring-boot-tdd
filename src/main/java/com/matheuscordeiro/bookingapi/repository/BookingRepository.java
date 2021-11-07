package com.matheuscordeiro.bookingapi.repository;

import com.matheuscordeiro.bookingapi.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByReserveName(String name);
}
