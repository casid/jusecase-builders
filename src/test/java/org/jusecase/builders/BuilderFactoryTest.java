package org.jusecase.builders;

import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.jusecase.builders.BuilderFactory.*;

public class BuilderFactoryTest {
    @Test
    public void instancesCanBeBuilt() {
//        instanceCanBeBuilt(inputStream(), InputStream.class);
//        instanceCanBeBuilt(date(), Date.class);
//        instanceCanBeBuilt(listWith("1", "2"), Arrays.asList("1", "2"));
//        instanceCanBeBuilt(setWith("1", "2"), new HashSet<String>(Arrays.asList("1", "2")));
//        arrayInstanceCanBeBuilt(arrayWith("1", "2"), new String[]{"1", "2"});

    }

    private <T> void instanceCanBeBuilt(Builder<T> builder, Class<T> expectedClass) {
        T instance = a(builder);
        assertNotNull(instance);
        assertTrue(expectedClass.isInstance(instance));
    }

    private <T> void instanceCanBeBuilt(Builder<T> builder, T expectedInstance) {
        T instance = a(builder);
        assertNotNull(instance);
        assertEquals(expectedInstance, instance);
    }

    private <T> void arrayInstanceCanBeBuilt(Builder<T[]> builder, T[] expectedInstance) {
        T[] instance = a(builder);
        assertNotNull(instance);
        assertArrayEquals(expectedInstance, instance);
    }
}