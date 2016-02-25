package org.jusecase.builders.newables;

import org.junit.Test;
import org.jusecase.builders.Newable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NewableArrayListTest {
    private final Newable<List<String>> newable = new NewableArrayList();

    @Test
    public void testNewInstanceIsArrayList() throws Exception {
        assertEquals(ArrayList.class, newable.newInstance().getClass());
    }

    @Test
    public void testNewInstanceIsNotNull() throws Exception {
        assertNotNull(newable.newInstance());
    }
}