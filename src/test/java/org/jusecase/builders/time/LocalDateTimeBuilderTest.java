package org.jusecase.builders.time;

import org.junit.Test;
import org.jusecase.builders.BuilderException;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.localDateTime;

public class LocalDateTimeBuilderTest {


    @Test(expected = BuilderException.class)
    public void dateCannotBeParsed() {
        a(localDateTime("iedio"));
    }

    @Test
    public void defaultDate() {
        assertEquals(a(localDateTime("2015-10-21 07:28:00")), a(localDateTime()));
    }

    @Test
    public void dateTimeIsParsedCorrectly() {
        LocalDateTime dateTime = a(localDateTime("2016-01-01 08:30:40"));
        assertEquals(dateTime.getYear(), 2016);
        assertEquals(dateTime.getMonthValue(), 1);
        assertEquals(dateTime.getDayOfMonth(), 1);
        assertEquals(dateTime.getHour(), 8);
        assertEquals(dateTime.getMinute(), 30);
        assertEquals(dateTime.getSecond(), 40);
    }

    @Test
    public void shortDateTimeIsParsedCorrectly() {
        LocalDateTime dateTime = a(localDateTime("2016-01-01"));
        assertEquals(dateTime.getYear(), 2016);
        assertEquals(dateTime.getMonthValue(), 1);
        assertEquals(dateTime.getDayOfMonth(), 1);
        assertEquals(dateTime.getHour(), 0);
        assertEquals(dateTime.getMinute(), 0);
        assertEquals(dateTime.getSecond(), 0);
    }
}
