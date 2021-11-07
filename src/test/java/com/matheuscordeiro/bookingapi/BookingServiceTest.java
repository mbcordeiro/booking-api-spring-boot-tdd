package com.matheuscordeiro.bookingapi;

import com.matheuscordeiro.bookingapi.model.Booking;
import com.matheuscordeiro.bookingapi.repository.BookingRepository;
import com.matheuscordeiro.bookingapi.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BookingServiceTest {
    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }

    @Before
    public void setUp() {
        var checkIn = LocalDate.parse("2021-11-07");
        var checkOut = LocalDate.parse("2021-11-17");
        var booking = Booking.builder().id(1L).reserveName("Matheus").checkIn(checkIn).checkOut(checkOut).build();
        when(bookingRepository.findByReserveName(booking.getReserveName())).thenReturn(Optional.of(booking));
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingServiceDaysCalculator() {
        var name = "Matheus";
        var days = bookingService.dayCalculator(name);
        assertEquals(days, 10);
    }
}
