package org.jusecase.builders.factories;

import org.junit.Test;
import org.jusecase.builders.builders.streams.ResourceInputStreamBuilder;
import org.jusecase.builders.builders.streams.StringInputStreamBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.jusecase.builders.factories.InputStreamBuilderFactory.resourceStream;
import static org.jusecase.builders.factories.InputStreamBuilderFactory.stringStream;

public class InputStreamBuilderFactoryTest {
    @Test
    public void testNotNull() throws Exception {
        assertNotNull(stringStream(""));
        assertNotNull(resourceStream(""));
    }

    @Test
    public void testBuilderClass() throws Exception {
        assertEquals(StringInputStreamBuilder.class, stringStream("").getClass());
        assertEquals(ResourceInputStreamBuilder.class, resourceStream("").getClass());
    }}