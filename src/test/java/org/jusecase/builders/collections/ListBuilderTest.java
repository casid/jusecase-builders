package org.jusecase.builders.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.*;

public class ListBuilderTest {
    @Test
    public void emptyList() {
        assertThat(a(list()).size()).isEqualTo(0);
    }

    @Test
    public void filledList() {
        List<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertThat(a(list("a", "b", "c"))).isEqualTo(expected);
    }

    @Test
    public void defaultListImplementation() {
        assertThat(a(list()).getClass()).isEqualTo(ArrayList.class);
    }

    @Test
    public void arrayListCanBeBuilt() {
        assertThat(a(arrayList()).getClass()).isEqualTo(ArrayList.class);
    }

    @Test
    public void linkedListCanBeBuilt() {
        assertThat(a(linkedList()).getClass()).isEqualTo(LinkedList.class);
    }
}
