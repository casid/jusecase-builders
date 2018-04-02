package org.jusecase.builders.time;

import org.junit.Test;
import org.jusecase.builders.BuilderException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.localDate;

public class LocalDateBuilderTest {

    @Test(expected = BuilderException.class)
    public void dateCannotBeParsed() {
        a(localDate("iedio"));
    }

    @Test(expected = BuilderException.class)
    public void timeCannotBeParsed() {
        a(localDate("2016-01-01 00:00:01"));
    }

    @Test
    public void defaultDate() {
        assertEquals(a(localDate("2015-10-21")), a(localDate()));
    }

    @Test
    public void dateIsParsedCorrectly() {
        LocalDate date = a(localDate("2016-01-01"));
        assertEquals(date.getYear(), 2016);
        assertEquals(date.getMonthValue(), 1);
        assertEquals(date.getDayOfMonth(), 1);
    }
}
