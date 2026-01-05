package org.jusecase.builders.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.an;
import static org.jusecase.Builders.entry;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class MapEntryBuilderTest {
    @Test
    public void testEntryContainsKeyAndValue() {
        final Map.Entry<String, String> mapEntry = an(entry("a", "b"));
        assertThat(mapEntry.getKey()).isEqualTo("a");
        assertThat(mapEntry.getValue()).isEqualTo("b");
    }

    @Test
    public void testEntryValueIsMutable() {
        final Map.Entry<String, String> mapEntry = an(entry("a", "b"));
        mapEntry.setValue("c");
        assertThat(mapEntry.getKey()).isEqualTo("a");
        assertThat(mapEntry.getValue()).isEqualTo("c");
    }
}
