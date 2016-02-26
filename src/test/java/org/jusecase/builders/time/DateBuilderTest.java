package org.jusecase.builders.time;

import org.junit.Test;
import org.jusecase.builders.BuilderException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.date;

public class DateBuilderTest {
    @Test(expected = BuilderException.class)
    public void dateCannotBeParsed() throws Exception {
        a(date().with("iedio"));
    }

    @Test
    public void dateIsParsedCorrectly() throws Exception {
        assertEquals(new Date(1451606401000L), a(date().with("2016-01-01 00:00:01")));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly() throws Exception {
        assertEquals(new Date(1451606400000L), a(date().with("2016-01-01", "yyyy-MM-dd")));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly() throws Exception {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        assertEquals(new Date(1451606400000L), a(date().with("2016-01-01", dateFormat)));
    }
}
