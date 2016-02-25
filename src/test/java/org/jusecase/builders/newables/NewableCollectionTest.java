package org.jusecase.builders.newables;

import org.junit.Test;
import org.jusecase.builders.Newable;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NewableCollectionTest {
    private final Newable<Collection<String>> newable = new NewableCollection<String>();

    @Test
    public void testNewInstanceIsArrayList() throws Exception {
        assertEquals(ArrayList.class, newable.newInstance().getClass());
    }

    @Test
    public void testNewInstanceIsNotNull() throws Exception {
        assertNotNull(newable.newInstance());
    }
}