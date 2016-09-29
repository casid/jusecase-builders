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
    public void dateCannotBeParsed() throws Exception {
        a(date().with("iedio"));
    }

    @Test
    public void now() throws Exception {
        assertTrue(new Date().getTime() <= a(date()).getTime());
    }

    @Test
    public void dateWithExplicitWith() throws Exception {
        assertEquals(new Date(1451606401000L), a(date().with("2016-01-01 00:00:01")));
    }

    @Test
    public void dateIsParsedCorrectly() throws Exception {
        assertEquals(new Date(1451606401000L), a(date("2016-01-01 00:00:01")));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly() throws Exception {
        assertEquals(new Date(1451606400000L), a(date("2016-01-01").withFormat("yyyy-MM-dd")));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly_legacyWay() throws Exception {
        assertEquals(new Date(1451606400000L), a(date().with("2016-01-01", "yyyy-MM-dd")));
    }

    @Test
    public void dateWithTimezoneIsParsedCorrectly() throws Exception {
        assertEquals(new Date(1451606401000L - CET_DIFFERENCE), a(date("2016-01-01 00:00:01").withTimezone("CET")));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly() throws Exception {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));

        assertEquals(new Date(1451606400000L - CET_DIFFERENCE), a(date("2016-01-01").withFormat(dateFormat)));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly_legacyWay() throws Exception {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));

        assertEquals(new Date(1451606400000L - CET_DIFFERENCE), a(date().with("2016-01-01", dateFormat)));
    }
}
