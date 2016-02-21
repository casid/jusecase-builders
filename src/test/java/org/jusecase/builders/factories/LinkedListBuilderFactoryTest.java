package org.jusecase.builders.factories;

import org.junit.Test;
import org.jusecase.builders.builders.collections.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.jusecase.builders.factories.LinkedListBuilderFactory.*;

public class LinkedListBuilderFactoryTest {
    private final List<String> list1 = new LinkedList<String>();
    private final List<String> list2 = new LinkedList<String>();

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