package org.jusecase.builders.time;

import org.junit.Test;
import org.jusecase.builders.BuilderException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.date;

public class DateBuilderTest {

    private static final long CET_DIFFERENCE = 3600 * 1000;

    @Test(expected = BuilderException.class)
    public void dateCannotBeParsed() {
        a(date().with("iedio"));
    }

    @Test
    public void defaultDate() {
        assertEquals(a(date("2015-10-21 07:28:00")), a(date()));
    }

    @Test
    public void now() {
        assertTrue(new Date().getTime() <= a(date().now()).getTime());
    }

    @Test
    public void dateWithExplicitWith() {
        assertEquals(new Date(1451606401000L), a(date().with("2016-01-01 00:00:01")));
    }

    @Test
    public void dateIsParsedCorrectly() {
        assertEquals(new Date(1451606401000L), a(date("2016-01-01 00:00:01")));
    }

    @Test
    public void dateIsParsedCorrectly_onlyDatePart() {
        assertEquals(new Date(1451606400000L), a(date("2016-01-01")));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly() {
        assertEquals(new Date(1451606400000L), a(date("2016-01-01").withFormat("yyyy-MM-dd")));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly_legacyWay() {
        assertEquals(new Date(1451606400000L), a(date().with("2016-01-01", "yyyy-MM-dd")));
    }

    @Test
    public void dateWithTimezoneIsParsedCorrectly() {
        assertEquals(new Date(1451606401000L - CET_DIFFERENCE), a(date("2016-01-01 00:00:01").withTimezone("CET")));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));

        assertEquals(new Date(1451606400000L - CET_DIFFERENCE), a(date("2016-01-01").withFormat(dateFormat)));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly_legacyWay() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));

        assertEquals(new Date(1451606400000L - CET_DIFFERENCE), a(date().with("2016-01-01", dateFormat)));
    }
}
