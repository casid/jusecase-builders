package org.jusecase.builders.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.path;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.jusecase.builders.BuilderException;

public class PathBuilderTest {
    @Test
    public void defaultPath() {
        assertThat(a(path())).isEqualTo(Paths.get(""));
    }

    @Test
    public void nullResource() {
        assertThrows(NullPointerException.class, () -> a(path().withResource(null)));
    }

    @Test
    public void resourceThatDoesNotExist() {
        assertThrows(BuilderException.class, () -> a(path().withResource("unknown.txt")));
    }

    @Test
    public void resourceThatExists() throws Exception {
        Path path = a(path().withResource("testresource.txt"));
        assertThat(new String(Files.readAllBytes(path))).isEqualTo("this is a test");
    }
}