package org.jusecase.builders.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.file;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.jusecase.builders.BuilderException;

public class FileBuilderTest {
    @Test
    public void defaultFile() {
        assertThat(a(file())).isEqualTo(new File(""));
    }

    @Test
    public void nullResource() {
        assertThrows(NullPointerException.class, () -> a(file().withResource(null)));
    }

    @Test
    public void resourceThatDoesNotExist() {
        assertThrows(BuilderException.class, () -> a(file().withResource("unknown.txt")));
    }

    @Test
    public void resourceThatExists() throws Exception {
        File file = a(file().withResource("testresource.txt"));
        assertThat(new String(Files.readAllBytes(file.toPath()))).isEqualTo("this is a test");
    }
}