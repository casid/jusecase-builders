package org.jusecase.builders.newables;

import org.junit.Test;
import org.jusecase.builders.Newable;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NewableHashSetTest {
    private final Newable<Set<String>> newable = new NewableHashSet<String>();

    @Test
    public void testNewInstanceIsHashSet() throws Exception {
        assertEquals(HashSet.class, newable.newInstance().getClass());
    }

    @Test
    public void testNewInstanceIsNotNull() throws Exception {
        assertNotNull(newable.newInstance());
    }

}