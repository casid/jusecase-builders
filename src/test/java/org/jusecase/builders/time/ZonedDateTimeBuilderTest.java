package org.jusecase.builders.time;

import org.junit.Test;
import org.jusecase.builders.BuilderException;

import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.zonedDateTime;

public class ZonedDateTimeBuilderTest {

    @Test(expected = BuilderException.class)
    public void dateCannotBeParsed() {
        a(zonedDateTime("iedio"));
    }

    @Test
    public void defaultDate() {
        assertEquals(a(zonedDateTime("2015-10-21 07:28:00 Europe/Berlin")), a(zonedDateTime()));
    }

    @Test
    public void dateIsParsedCorrectly() {
        ZonedDateTime dateTime = a(zonedDateTime("2016-01-01 08:30:40 Europe/Berlin"));
        assertEquals(dateTime.getYear(), 2016);
        assertEquals(dateTime.getMonthValue(), 1);
        assertEquals(dateTime.getDayOfMonth(), 1);
        assertEquals(dateTime.getHour(), 8);
        assertEquals(dateTime.getMinute(), 30);
        assertEquals(dateTime.getSecond(), 40);
    }
}
