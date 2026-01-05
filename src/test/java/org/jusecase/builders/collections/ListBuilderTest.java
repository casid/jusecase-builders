package org.jusecase.builders.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.arrayList;
import static org.jusecase.Builders.linkedList;
import static org.jusecase.Builders.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListBuilderTest {
    @Test
    public void emptyList() {
        assertThat(a(list()).size()).isEqualTo(0);
    }

    @Test
    public void filledList() {
        assertThat(a(list("a", "b", "c"))).isEqualTo(List.of("a", "b", "c"));
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
