package org.jusecase.builders.structures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.an;
import static org.jusecase.Builders.array;

public class ArrayBuilderTest {

    @Test
    public void filledArray() {
        assertThat(an(array(1, 2, 3, 4))).isEqualTo(new Integer[]{1, 2, 3, 4});
    }

    @Test
    public void copy() {
        String[] original = new String[]{"a", "b", "c"};
        String[] copy = new ArrayBuilder<String>(original).copy().build();

        assertThat(copy).isEqualTo(original);
        assertThat(copy).isNotSameAs(original);
    }
}