package org.jusecase.builders.builders.structures;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static org.jusecase.builders.Builders.an;
import static org.jusecase.builders.Builders.array;

public class ArrayBuilderTest {

    @Test(expected = NullPointerException.class)
    public void nullArray() {
        an(array(null));
    }

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