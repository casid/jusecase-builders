package org.jusecase.builders;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;
import static org.jusecase.builders.Builders.*;

public class BuildersTest implements Builder<String> {

    private boolean buildHasBeenCalled;

    @Before
    public void setUp() throws Exception {
        this.buildHasBeenCalled = false;
    }

    @Test
    public void testAIsCallingBuild() throws Exception {
        a(this);
        assertTrue(this.buildHasBeenCalled);
    }

    @Test
    public void testAnIsCallingBuild() throws Exception {
        an(this);
        assertTrue(this.buildHasBeenCalled);
    }

    @Test
    public void testOfReturnsInput() throws Exception {
        final String input = "input";
        final String output = of(input);
        assertEquals(input, output);
    }

    @Test
    public void testOfArrayReturnsInput() throws Exception {
        final String[] input = new String[]{"input"};
        final String[] output = of(input);
        assertSame(input, output);
    }

    @Test
    public void dateIsParsedCorrectly() throws Exception {
        assertEquals(new Date(1451606401000L), a(date("2016-01-01 00:00:01")));
    }

    @Test
    public void dateWithFormatIsParsedCorrectly() throws Exception {
        assertEquals(new Date(1451606400000L), a(date("2016-01-01", "yyyy-MM-dd")));
    }

    @Test
    public void dateWithCustomFormatIsParsedCorrectly() throws Exception {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        assertEquals(new Date(1451606400000L), a(date("2016-01-01", dateFormat)));
    }

    @Override
    public String build() {
        this.buildHasBeenCalled = true;
        return "";
    }
}
