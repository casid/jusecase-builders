package org.jusecase.builders.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.jusecase.builders.Builders.*;

public class ListBuilderTest {
    @Test
    public void emptyList() {
        assertEquals(0, a(list()).size());
    }

    @Test
    public void filledList() {
        List<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertEquals(expected, a(list("a", "b", "c")));
    }

    @Test
    public void defaultListImplementation() {
        assertEquals(ArrayList.class, a(list()).getClass());
    }

    @Test
    public void arrayListCanBeBuilt() {
        assertEquals(ArrayList.class, a(arrayList()).getClass());
    }

    @Test
    public void linkedListCanBeBuilt() {
        assertEquals(LinkedList.class, a(linkedList()).getClass());
    }
}
