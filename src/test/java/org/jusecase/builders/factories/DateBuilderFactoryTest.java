package org.jusecase.builders.factories;

import org.junit.Test;
import org.jusecase.builders.builders.misc.DateBuilder;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.jusecase.builders.factories.DateBuilderFactory.*;

public class DateBuilderFactoryTest {

    @Test
    public void testNotNull() throws Exception {
        assertNotNull(date("2016-01-01 00:00:01"));
        assertNotNull(date("2016-01-01", new SimpleDateFormat("yyyy-mm-dd")));
    }

    @Test
    public void testBuilderClass() throws Exception {
        assertEquals(DateBuilder.class, date("2016-01-01 00:00:01").getClass());
        assertEquals(DateBuilder.class, date("2016-01-01", new SimpleDateFormat("yyyy-mm-dd")).getClass());
    }
}