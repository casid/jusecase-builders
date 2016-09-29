package org.jusecase.builders.collections;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.an;
import static org.jusecase.Builders.entry;

public class MapEntryBuilderTest {
    @Test
    public void testEntryContainsKeyAndValue(){
        final Map.Entry<String,String> mapEntry = an(entry("a", "b"));
        assertEquals("a", mapEntry.getKey());
        assertEquals("b", mapEntry.getValue());
    }

    @Test
    public void testEntryValueIsMutable(){
        final Map.Entry<String,String> mapEntry = an(entry("a", "b"));
        mapEntry.setValue("c");
        assertEquals("a", mapEntry.getKey());
        assertEquals("c", mapEntry.getValue());
    }
}
