package org.jusecase.builders.factories;

import org.junit.Test;
import org.jusecase.builders.builders.collections.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.jusecase.builders.factories.HashSetBuilderFactory.*;

public class HashSetBuilderFactoryTest {
    private final Set<String> set1 = new HashSet<String>();
    private final Set<String> set2 = new HashSet<String>();

    @Test
    public void testNotNull() throws Exception {
        assertNotNull(set(1,2));
        assertNotNull(copy(set1));
        assertNotNull(aggregate(set1, set2));
        assertNotNull(unmodifiable(set1));
        assertNotNull(immutable(set1));
    }

    @Test
    public void testBuilderClass() throws Exception {
        assertEquals(CollectionBuilder.class, set(1,2).getClass());
        assertEquals(CopyCollectionBuilder.class, copy(set1).getClass());
        assertEquals(AggregateCollectionBuilder.class, aggregate(set1, set2).getClass());
        assertEquals(UnmodifiableCollectionBuilder.class, unmodifiable(set1).getClass());
        assertEquals(ImmutableCollectionBuilder.class, immutable(set1).getClass());
    }

}