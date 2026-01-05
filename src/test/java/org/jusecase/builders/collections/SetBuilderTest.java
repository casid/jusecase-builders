package org.jusecase.builders.collections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.*;

public class SetBuilderTest {
    @Test
    public void emptySet() {
        assertThat(a(set()).size()).isEqualTo(0);
    }

    @Test
    public void filledSet() {
        Set<String> expected = new HashSet<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");

        assertThat(a(set("a", "b", "c"))).isEqualTo(expected);
    }

    @Test
    public void filledSet_duplicatesAreIgnored() {
        Set<String> expected = new HashSet<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("c");

        assertThat(a(set("a", "b", "c", "c"))).isEqualTo(expected);
    }

    @Test
    public void defaultSetImplementation() {
        assertThat(a(set()).getClass()).isEqualTo(HashSet.class);
    }

    @Test
    public void hashSetCanBeBuilt() {
        assertThat(a(hashSet()).getClass()).isEqualTo(HashSet.class);
    }

    @Test
    public void sortedSetCanBeBuilt() {
        assertThat(a(sortedSet()).getClass()).isEqualTo(TreeSet.class);
    }
}
