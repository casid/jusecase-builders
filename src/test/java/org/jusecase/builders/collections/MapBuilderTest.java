package org.jusecase.builders.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.an;
import static org.jusecase.Builders.entry;
import static org.jusecase.Builders.hashMap;
import static org.jusecase.Builders.linkedHashMap;
import static org.jusecase.Builders.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class MapBuilderTest {
    @Test
    public void emptyMap() {
        assertThat(a(map()).size()).isEqualTo(0);
    }

    @Test
    public void filledMap() {
        Map<String, String> expected = new HashMap<>();
        expected.put("a", "a");
        expected.put("b", "b");
        expected.put("c", "c");

        assertThat(a(map(an(entry("a", "a")), an(entry("b", "b")), an(entry("c", "c"))))).isEqualTo(expected);
    }

    @Test
    public void defaultMapImplementation() {
        assertThat(a(map()).getClass()).isEqualTo(HashMap.class);
    }

    @Test
    public void hashMapCanBeBuilt() {
        assertThat(a(hashMap()).getClass()).isEqualTo(HashMap.class);
    }

    @Test
    public void linkedHashMapCanBeBuilt() {
        assertThat(a(linkedHashMap()).getClass()).isEqualTo(LinkedHashMap.class);
    }
}
