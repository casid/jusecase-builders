package org.jusecase.builders.factories;

import org.junit.Test;
import org.jusecase.builders.builders.structures.ArrayBuilder;

import static org.junit.Assert.*;
import static org.jusecase.builders.factories.ArrayBuilderFactory.array;

public class ArrayBuilderFactoryTest {

    @Test
    public void testNotNull() throws Exception {
        assertNotNull(array(1,2));
    }

    @Test
    public void testBuilderClass() throws Exception {
        assertEquals(ArrayBuilder.class, array(1,2).getClass());
    }
}