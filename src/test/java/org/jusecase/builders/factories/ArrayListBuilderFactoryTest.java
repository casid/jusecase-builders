package org.jusecase.builders.factories;

import org.junit.Test;
import org.jusecase.builders.builders.collections.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.jusecase.builders.factories.ArrayListBuilderFactory.*;

public class ArrayListBuilderFactoryTest {
    private final List<String> list1 = new ArrayList<String>();
    private final List<String> list2 = new ArrayList<String>();

    @Test
    public void testNotNull() throws Exception {
        assertNotNull(list(1,2));
        assertNotNull(copy(list1));
        assertNotNull(aggregate(list1, list2));
        assertNotNull(unmodifiable(list1));
        assertNotNull(immutable(list1));
    }

    @Test
    public void testBuilderClass() throws Exception {
        assertEquals(CollectionBuilder.class, list(1,2).getClass());
        assertEquals(CopyCollectionBuilder.class, copy(list1).getClass());
        assertEquals(AggregateCollectionBuilder.class, aggregate(list1, list2).getClass());
        assertEquals(UnmodifiableCollectionBuilder.class, unmodifiable(list1).getClass());
        assertEquals(ImmutableCollectionBuilder.class, immutable(list1).getClass());
    }
}