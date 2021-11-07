package com.matheuscordeiro.bookingapi;

import com.matheuscordeiro.bookingapi.service.BookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class BookingServiceTest {
    @Autowired
    BookingService bookingService;

    @Test
    public void bookingServiceDaysCalculator() {
        var name = "Name";
        var days = bookingService.dayCalculator(name);
        assertEquals(days, 10);
    }
}
