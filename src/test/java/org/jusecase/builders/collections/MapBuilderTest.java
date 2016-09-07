package org.jusecase.builders.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.*;

public class MapBuilderTest {
    @Test
    public void emptyMap() {
        assertEquals(0, a(map()).size());
    }

    @Test
    public void filledMap() {
        Map<String,String> expected = new HashMap<String,String>();
        expected.put("a","a");
        expected.put("b","b");
        expected.put("c","c");

        assertEquals(expected, a(map(an(entry("a","a")),an(entry("b","b")),an(entry("c","c")))));
    }

    @Test
    public void defaultMapImplementation() {
        assertEquals(HashMap.class, a(map()).getClass());
    }

    @Test
    public void hashMapCanBeBuilt() {
        assertEquals(HashMap.class, a(hashMap()).getClass());
    }

    @Test
    public void linkedHashMapCanBeBuilt() {
        assertEquals(LinkedHashMap.class, a(linkedHashMap()).getClass());
    }
}
