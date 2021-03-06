package org.jusecase.builders.structures;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static org.jusecase.Builders.an;
import static org.jusecase.Builders.array;

public class ArrayBuilderTest {

    @Test
    public void filledArray() {
        assertArrayEquals(new Integer[]{1,2,3,4}, an(array(1, 2, 3, 4)));
    }

    @Test
    public void copy() {
        String[] original = new String[]{"a", "b", "c"};
        String[] copy = new ArrayBuilder<String>(original).copy().build();

        assertArrayEquals(original, copy);
        assertNotSame(original, copy);
    }
}