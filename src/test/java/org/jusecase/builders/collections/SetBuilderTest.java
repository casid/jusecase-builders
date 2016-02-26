package org.jusecase.builders.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.*;

public class SetBuilderTest {
    @Test
    public void emptySet() {
        assertEquals(0, a(set()).size());
    }

    @Test
    public void filledSet() {
        Set<String> expected = new HashSet<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertEquals(expected, a(set("a", "b", "c")));
    }

    @Test
    public void filledSet_duplicatesAreIgnored() {
        Set<String> expected = new HashSet<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("c");

        assertEquals(expected, a(set("a", "b", "c", "c")));
    }

    @Test
    public void defaultSetImplementation() {
        assertEquals(HashSet.class, a(set()).getClass());
    }

    @Test
    public void hashSetCanBeBuilt() {
        assertEquals(HashSet.class, a(hashSet()).getClass());
    }
}
