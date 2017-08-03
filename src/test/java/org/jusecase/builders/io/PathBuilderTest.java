package org.jusecase.builders.io;

import org.junit.Test;
import org.jusecase.builders.BuilderException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.path;

public class PathBuilderTest {
    @Test
    public void defaultPath() {
        assertEquals(Paths.get(""), a(path()));
    }

    @Test(expected = NullPointerException.class)
    public void nullResource() {
        a(path().withResource(null));
    }

    @Test(expected = BuilderException.class)
    public void resourceThatDoesNotExist() {
        a(path().withResource("unknown.txt"));
    }

    @Test
    public void resourceThatExists() throws Exception {
        Path path = a(path().withResource("testresource.txt"));
        assertEquals("this is a test", new String(Files.readAllBytes(path)));
    }
}