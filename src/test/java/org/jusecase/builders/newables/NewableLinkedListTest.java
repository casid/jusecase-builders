package org.jusecase.builders.newables;

import org.junit.Test;
import org.jusecase.builders.Newable;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NewableLinkedListTest {
    private final Newable<List<String>> newable = new NewableLinkedList<String>();

    @Test
    public void testNewInstanceIsLinkedList() throws Exception {
        assertEquals(LinkedList.class, newable.newInstance().getClass());
    }

    @Test
    public void testNewInstanceIsNotNull() throws Exception {
        assertNotNull(newable.newInstance());
    }
}