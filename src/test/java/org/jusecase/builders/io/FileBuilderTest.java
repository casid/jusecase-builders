package org.jusecase.builders.io;

import org.junit.Test;
import org.jusecase.builders.BuilderException;

import java.io.File;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.file;

public class FileBuilderTest {
    @Test
    public void defaultFile() {
        assertEquals(new File(""), a(file()));
    }

    @Test(expected = NullPointerException.class)
    public void nullResource() {
        a(file().withResource(null));
    }

    @Test(expected = BuilderException.class)
    public void resourceThatDoesNotExist() {
        a(file().withResource("unknown.txt"));
    }

    @Test
    public void resourceThatExists() throws Exception {
        File file = a(file().withResource("testresource.txt"));
        assertEquals("this is a test", new String(Files.readAllBytes(file.toPath())));
    }
}